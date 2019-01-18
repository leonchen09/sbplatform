package com.battery.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.weaver.AjAttribute.AjSynthetic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.battery.common.Constant;
import com.battery.common.controller.BaseController;
import com.battery.common.utils.jwt.JwtHelper;
import com.battery.common.vo.AjaxResponse;
import com.battery.core.models.User;
import com.battery.core.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/token")
public class TokenController extends BaseController {
	
	Logger log = LoggerFactory.getLogger(TokenController.class);
	
	@Autowired
	UserService userService;
	
	@ApiOperation(value = "更新token")
	@RequestMapping(value = "/renew", method = RequestMethod.POST)
	public AjaxResponse<User> updateToken(HttpServletRequest request) {
		AjaxResponse<User> ajaxResponse = new AjaxResponse<User>(Constant.RS_CODE_ERROR, "更新token失败");
		Integer userId = Integer.parseInt((String)request.getAttribute("_userId"));
		User user = userService.selectByPrimaryKey(userId);
		if(user == null) {
			ajaxResponse.setCode("-1");
			ajaxResponse.setMsg("用户不存在，请重新登录！");
			return ajaxResponse; 
		}
		String tokenStr = JwtHelper.createToken((String)request.getAttribute("_userId"),(String)request.getAttribute("_userType"));
		user.setToken(tokenStr);
		user.setUserPassword(null);
		ajaxResponse.setCode(Constant.RS_CODE_SUCCESS);
		ajaxResponse.setMsg("更新token成功");
		ajaxResponse.setData(user);
		return ajaxResponse;
	}

	@ApiOperation(value = "获取token")
	@RequestMapping(value = "/get/{userId}", method = RequestMethod.POST)
	public AjaxResponse<String> getToken(@PathVariable String userId) {
		AjaxResponse<String> ajaxResponse = new AjaxResponse<String>(Constant.RS_CODE_ERROR, "获取token失败");
		try {
			User user = userService.selectByPrimaryKey(Integer.parseInt(userId));
			if(user != null) {
				ajaxResponse.setCode(Constant.RS_CODE_SUCCESS);
				ajaxResponse.setMsg("获取token成功");
				String tokenStr = JwtHelper.createToken(userId,user.getUserType().toString());
				ajaxResponse.setData(tokenStr);
			}
		} catch (Exception e) {
			log.info("获取token失败,用户id不存在userId={}",userId);
		}
		return ajaxResponse;
	}
}
