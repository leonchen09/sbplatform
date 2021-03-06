package com.battery.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.battery.common.Constant;
import com.battery.common.controller.BaseController;
import com.battery.common.utils.StringUtils;
import com.battery.common.vo.AjaxResponse;
import com.battery.common.vo.ShowPage;
import com.battery.core.models.Company;
import com.battery.core.models.User;
import com.battery.core.service.CompanyService;
import com.battery.core.service.UserService;
import com.battery.core.util.UserKit;
import com.battery.core.vo.response.CompanyWrap;
import com.battery.core.vo.search.SearchCompanyPagingVo;

import io.swagger.annotations.ApiOperation;

/**
 * This class was generated by Bill Generator. This class corresponds to the
 * database table companies 公司
 *
 * @zdmgenerated 2017-06-18 05:06
 */
@Controller
@RequestMapping(value = "/company")
public class CompanyController extends BaseController {
	@Autowired
	CompanyService companySer;
	// @Autowired
	// RedisClientTemplate template;
	@Autowired
	UserService userSer;

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "根据条件获取公司列表", notes = "返回公司列表")
	public AjaxResponse<List<Company>> getCompanyList(@RequestBody Company queryCompany) {
		Integer companyId = queryCompany.getCompanyId();
		queryCompany.setCompanyId(null);
		List<Company> companyList = companySer.selectListSelective(queryCompany);
		// 解决公司管理修改时，把自己的公司等级下调，导致选择上级公司时，包含自己
		// web端修改公司时，把当前公司的 id 传过来
		if (companyId != null) {
			companyList = companyList.stream().filter(c -> !c.getCompanyId().equals(companyId))
					.collect(Collectors.toList());
		}
		AjaxResponse<List<Company>> ajaxResponse = new AjaxResponse<List<Company>>(companyList);
		return ajaxResponse;
	}

	@RequestMapping(value = "/listPage", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "根据条件获取公司列表分页", notes = "返回公司列表分页")
	public AjaxResponse<ShowPage<CompanyWrap>> getCompanyListPage(
			@RequestBody SearchCompanyPagingVo searchCompanyPagingVo) {
		if (StringUtils.isNotEmpty(searchCompanyPagingVo.getCompanyName()))
			searchCompanyPagingVo.setCompanyName("%" + searchCompanyPagingVo.getCompanyName() + "%");
		else
			searchCompanyPagingVo.setCompanyName(null);
		List<Company> companyList = companySer.selectListSelectivePaging(searchCompanyPagingVo);
		List<CompanyWrap> companyWraps = companyList.stream().map(tmp -> {
			CompanyWrap dest = new CompanyWrap();
			BeanUtils.copyProperties(tmp, dest);
			if (tmp.getParentCompanyId() != null && tmp.getParentCompanyId() > 0) {
				dest.setParentCompanyName(companySer.selectByPrimaryKey(tmp.getParentCompanyId()).getCompanyName());
			}
			return dest;
		}).filter(c -> c.getParentCompanyId() != null).collect(Collectors.toList());
		ShowPage<CompanyWrap> page = new ShowPage<CompanyWrap>(searchCompanyPagingVo, companyWraps);
		AjaxResponse<ShowPage<CompanyWrap>> ajaxResponse = new AjaxResponse<ShowPage<CompanyWrap>>(page);
		return ajaxResponse;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增公司", notes = "新增公司")
	public AjaxResponse<Company> save(@RequestBody Company company, HttpServletRequest request) {
		setLoginUserInfo(company, request);
		company.setCompanyId(null);
		AjaxResponse<Company> ajaxResponse = new AjaxResponse<Company>(Constant.RS_CODE_ERROR, "添加公司出错！");
		request.setAttribute(Constant.ERROR_REQUEST, ajaxResponse);
		// 增加逻辑，防止公司名重复，只根据公司名查询
		Company temp = new Company();
		temp.setCompanyName(company.getCompanyName());
		int i = companySer.selectListCountSelective(temp);
		if (i > 0) {
			ajaxResponse.setCode(Constant.ERROR_REQUEST);
			ajaxResponse.setMsg("公司已存在！");
		} else {
			companySer.insertSelective(company);
			ajaxResponse.setCode(Constant.RS_CODE_SUCCESS);
			ajaxResponse.setMsg("添加公司成功！");
		}
		return ajaxResponse;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "根据pk更新公司", notes = "根据pk更新公司，属性为null的不更新")
	public AjaxResponse<Object> update(@RequestBody Company company, HttpServletRequest request) {
		setLoginUserInfo(company, request);
		if (company.getCompanyId() == null) {
			return new AjaxResponse<Object>(Constant.RS_CODE_ERROR, "请设置pk！");
		}
		AjaxResponse<Object> ajaxResponse = new AjaxResponse<Object>(Constant.RS_CODE_ERROR, "修改公司出错！");
		request.setAttribute(Constant.ERROR_REQUEST, ajaxResponse);
		if (new Integer(1).equals(company.getCompanyLevel())) {
			company.setParentCompanyId(-1);
		}


		// 是否修改公司名称
		Company record = new Company();
		record.setCompanyName(company.getCompanyName());
		List<Company> list = companySer.selectListSelective(record);
		if (CollectionUtils.isNotEmpty(list) && list.get(0).getCompanyId() != company.getCompanyId()) {
			ajaxResponse.setMsg("公司名已存在");
			return ajaxResponse;
		}

		companySer.updateByPrimaryKeySelective(company);

		User user = new User();
		user.setCompanyId(company.getCompanyId());
		user.setCompanyName(company.getCompanyName());
		userSer.updateByCompanyIdSelective(user);
		ajaxResponse.setCode(Constant.RS_CODE_SUCCESS);
		ajaxResponse.setMsg("修改公司成功！");
		return ajaxResponse;
	}

	@RequestMapping(value = "/entity/{companyId}", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "根据pk获取公司", notes = "根据pk获取公司")
	public AjaxResponse<Company> getEntity(@PathVariable Integer companyId) {
		if (companyId == null) {
			return new AjaxResponse<Company>(Constant.RS_CODE_ERROR, "请选择pk！");
		}
		Company company = companySer.selectByPrimaryKey(companyId);
		AjaxResponse<Company> ajaxResponse = new AjaxResponse<Company>(Constant.RS_CODE_SUCCESS, "获取公司成功！");
		if (company != null) {
			ajaxResponse.setData(company);
		} else {
			ajaxResponse.setCode(Constant.RS_CODE_ERROR);
			ajaxResponse.setMsg("获取公司失败！");
		}
		return ajaxResponse;
	}

	/**
	 * 配置
	 * 
	 * @param RolesDetail
	 * @param request
	 */
	private void setLoginUserInfo(Company company, HttpServletRequest request) {
		User loginUser = UserKit.getLoginUser(request);
		company.setCreateId(loginUser.getUserId());
		company.setCreateName(loginUser.getUserName());
	}
}