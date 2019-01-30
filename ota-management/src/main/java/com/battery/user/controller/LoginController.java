package com.battery.user.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.battery.common.Constant;
import com.battery.common.controller.BaseController;
import com.battery.common.redis.RedisClientTemplate;
import com.battery.common.utils.CommonUtil;
import com.battery.common.utils.RandomUtil;
import com.battery.common.utils.jwt.JwtHelper;
import com.battery.common.vo.AjaxResponse;
import com.battery.core.models.Permissions;
import com.battery.core.models.User;
import com.battery.core.service.CompanyService;
import com.battery.core.service.PermissionsService;
import com.battery.core.service.UserService;
import com.battery.core.vo.LoginUserVo;
import com.battery.core.vo.PhoneLoginUserVo;
import com.battery.user.config.VerificationCodeProperties;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

@RestController
@RequestMapping(value = "/login")
@EnableConfigurationProperties(VerificationCodeProperties.class)
public class LoginController extends BaseController {
	
	@Autowired
	CompanyService companySer;
	@Autowired
	private UserService userSer;
	@Autowired
	PermissionsService permissionsSer;
	@Autowired
	RedisClientTemplate redisClientTemplate;
	
	@Autowired
	VerificationCodeProperties verificationCodeProperties;
	
	//手机验证码redis key的前缀
	private final static String PHONE_LOGIN_PRIFIX = "login";
	//验证码随机数
	private final static String PHONE_LOGIN_KEY_RANDOM = "num";
	//验证码创建时间
	private final static String PHONE_LOGIN_KEY_CREATETIME = "ct";
	
	private Logger log = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public AjaxResponse<User> doLogin(@RequestBody LoginUserVo loginUser,HttpServletRequest request) {
		AjaxResponse<User> ajaxResponse = validateBean(loginUser);
		if (Constant.RS_CODE_SUCCESS != ajaxResponse.getCode()) {
			return ajaxResponse;
		}
		request.setAttribute(Constant.ERROR_REQUEST, ajaxResponse);
		User queryUser = new User();
		BeanUtils.copyProperties(loginUser, queryUser);
		queryUser.setDisableFlag(0);
		// 按用户名/密码查询出用户，不判断usertype。
		queryUser.setUserType(null);
		List<User> users = userSer.selectListSelective(queryUser);
		ajaxResponse = new AjaxResponse<>(Constant.RS_CODE_ERROR, "用户名或密码错误！");
		if (users.size() == 0) {
			return ajaxResponse;
		}
		User user = users.get(0);
//		if ((user.getUserType().intValue() & loginUser.getUserType().intValue()) != loginUser.getUserType()) {
//			return new AjaxResponse<>(Constant.RS_CODE_ERROR, "当前用户无权访问当前系统！");
//		}
		String tokenStr = JwtHelper.createToken(user.getUserId().toString(),user.getUserType().toString());
		user.setToken(tokenStr);
		List<Permissions> permissionList = permissionsSer.selectListByUserId(user.getUserId());
		permissionList = permissionList.stream().filter(p -> p.getPermissionSystem() == user.getUserType())
				.collect(Collectors.toList());
		Set<String> permissionCodeList = permissionList.stream().flatMap(p -> Stream.of(p.getPermissionCode()))
				.collect(Collectors.toSet());
		user.setPermissionCodeList(permissionCodeList);
//		//将通过用户返回公司放到user里面
//		List<Map<String, String>> companyList = companySer.selectCompany1ById(user.getCompanyId());
//		if(companyList.size() != 0) {
//		Map<String, String> map = companyList.get(0);
//		user.setCompany1(map.get("company1"));
//		user.setCompany2(map.get("company2"));
//		user.setCompany3(map.get("company3"));
//		}
		user.setUserPassword(null);
		//-------end
		ajaxResponse.setCode(Constant.RS_CODE_SUCCESS);
		ajaxResponse.setMsg("用户登录成功");
		ajaxResponse.setData(user);
		return ajaxResponse;
	}
	
	@RequestMapping(value = "/doPhoneLogin", method = RequestMethod.POST)
	public AjaxResponse<User> doPhoneLogin(@RequestBody PhoneLoginUserVo phoneLoginUserVo,HttpServletRequest request) {
		AjaxResponse<User> ajaxResponse = validateBean(phoneLoginUserVo);
		if (Constant.RS_CODE_SUCCESS != ajaxResponse.getCode()) {
			return ajaxResponse;
		}
		
		//验证码是否有效
		if(verificationCodeProperties.expiretime != null && !checkVerificationCode(phoneLoginUserVo.getUserPhone(),phoneLoginUserVo.getVerificationCode())) {
			ajaxResponse = new AjaxResponse<>(Constant.RS_CODE_ERROR, "验证码错误或已经过期!");
			return ajaxResponse;
		}
		
		request.setAttribute(Constant.ERROR_REQUEST, ajaxResponse);
		User queryUser = new User();
		BeanUtils.copyProperties(phoneLoginUserVo, queryUser);
		queryUser.setDisableFlag(0);
		// 按用户名/密码查询出用户，不判断usertype。
		queryUser.setUserType(null);
		List<User> users = userSer.selectListSelective(queryUser);
		if (users.size() == 0) {
			ajaxResponse = new AjaxResponse<>(Constant.RS_CODE_ERROR, "用户或密码错误!");
			return ajaxResponse;
		}
		User user = users.get(0);
		if ((user.getUserType().intValue() & phoneLoginUserVo.getUserType().intValue()) != phoneLoginUserVo.getUserType()) {
			return new AjaxResponse<>(Constant.RS_CODE_ERROR, "当前用户无权访问当前系统！");
		}
		String tokenStr = JwtHelper.createToken(user.getUserId().toString(),user.getUserType().toString());
		user.setToken(tokenStr);
		List<Permissions> permissionList = permissionsSer.selectListByUserId(user.getUserId());
		permissionList = permissionList.stream().filter(p -> p.getPermissionSystem() == user.getUserType())
				.collect(Collectors.toList());
		Set<String> permissionCodeList = permissionList.stream().flatMap(p -> Stream.of(p.getPermissionCode()))
				.collect(Collectors.toSet());
		user.setPermissionCodeList(permissionCodeList);
		//将通过用户返回公司放到user里面
		List<Map<String, String>> companyList = companySer.selectCompany1ById(user.getCompanyId());
		if(companyList.size() != 0) {
		Map<String, String> map = companyList.get(0);
		user.setCompany1(map.get("company1"));
		user.setCompany2(map.get("company2"));
		user.setCompany3(map.get("company3"));
		}
		user.setUserPassword(null);
		//-------end
		ajaxResponse.setCode(Constant.RS_CODE_SUCCESS);
		ajaxResponse.setMsg("用户登录成功");
		ajaxResponse.setData(user);
		return ajaxResponse;
	}
	
	
	@RequestMapping(value = "/getCode/{phone}", method = RequestMethod.GET)
	public AjaxResponse<Map<String,String>> doPhoneLogin(@PathVariable String phone) {
		AjaxResponse<Map<String,String>> ajaxResponse = null;
		if(!CommonUtil.isMobileNO(phone)) {
			ajaxResponse = new AjaxResponse<>(Constant.RS_CODE_ERROR,"手机号格式错误!");
		}
		
		User queryUser = new User();
		queryUser.setUserPhone(phone);
		queryUser.setDisableFlag(0);
		// 按用户名/密码查询出用户，不判断usertype。
		queryUser.setUserType(null);
		List<User> users = userSer.selectListSelective(queryUser);
		if (users.size() == 0) {
			ajaxResponse = new AjaxResponse<>(Constant.RS_CODE_ERROR, "未找到用户!");
			return ajaxResponse;
		}
		
		try {
			sendVerificationCode(phone);
		} catch (Exception e) {
			log.error("短信验证码发送失败,号码:"+phone,e);
			ajaxResponse = new AjaxResponse<>(Constant.RS_CODE_ERROR,"短信发送失败,请稍后重试!");
			return ajaxResponse;
		}
		ajaxResponse = new AjaxResponse<Map<String,String>>(Constant.RS_CODE_ERROR,"发送成功!");
		return ajaxResponse;
	}
	
	
	/**
	 * 通过用户id返回公司
	 */
	@RequestMapping(value="/user",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse<List<Map<String, String>>> getCompany3ByUserId(@RequestBody User user){
		String loginId = user.getLoginId();
		List<Map<String, String>> selectCompany1ByUser = companySer.selectCompany1ByUser(loginId);
		AjaxResponse<List<Map<String,String>>> ajaxResponse =  new AjaxResponse<List<Map<String, String>>>(Constant.RS_CODE_SUCCESS,"获取成功");
		ajaxResponse.setData(selectCompany1ByUser);
		return ajaxResponse;
	}
	
	/**
	 * 发送验证码,
	 * @param num
	 * @return
	 * @throws Exception 
	 */
	private String sendVerificationCode(String phone) throws Exception {
		if(verificationCodeProperties.expiretime == null) {
			throw new RuntimeException("短信发送失败,后台未配置短信发送功能");
		}
		//检查是否频繁发送
		checkSendIntervalTime(phone);
		String randomNum = RandomUtil.randomdigit(5) + "";
		//发送验证码
		String content = verificationCodeProperties.content.replaceAll("\\{randomNum\\}", randomNum).replaceAll("\\{minute\\}", verificationCodeProperties.expiretime+"");
		
		SmsSingleSender sender = new SmsSingleSender(verificationCodeProperties.appid, verificationCodeProperties.appkey);
		SmsSingleSenderResult result = sender.send(0, "86", phone, content , "", "");
		try {
			if(result.result != 0) {
				throw new RuntimeException("短信发送失败,错误:"+result.result);
			}
		} catch (Exception e) {
			throw e;
		}
		
		//redis,保存验证码,设置过期时间
		String redisKey = PHONE_LOGIN_PRIFIX+phone;
		redisClientTemplate.hset(redisKey, PHONE_LOGIN_KEY_RANDOM, randomNum);
		redisClientTemplate.hset(redisKey, PHONE_LOGIN_KEY_CREATETIME, String.valueOf(new Date().getTime()));
		redisClientTemplate.expire(redisKey, verificationCodeProperties.expiretime*60);
		return randomNum;
	}
	
	/**
	 * 检查发送间隔时间
	 * @param phone
	 */
	private void checkSendIntervalTime(String phone) {
		String time = redisClientTemplate.hget(PHONE_LOGIN_PRIFIX+phone, PHONE_LOGIN_KEY_CREATETIME);
		//间隔发送时间不超过分钟数,默认为1
		if(time != null && Long.parseLong(time) - new Date().getTime() <= verificationCodeProperties.intervaltime * 60000) {
			throw new RuntimeException("请不要频繁发送验证码,请等待运营商发送短信!");
		}
	}
	
	/**
	 * 检查验证码是否有效
	 * @param num
	 * @return
	 */
	private boolean checkVerificationCode(String num,String verificationCode) {
		String redisVerificationCode = redisClientTemplate.hget(PHONE_LOGIN_PRIFIX+num, PHONE_LOGIN_KEY_RANDOM);
		return redisVerificationCode != null && redisVerificationCode.equals(verificationCode) ? true : false;
	}
}
