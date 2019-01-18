package com.battery.core.service;

import java.util.List;
import java.util.Map;

import com.battery.common.service.BaseService;
import com.battery.core.models.Company;


public interface CompanyService extends BaseService<Company, Integer> 
{
	
	int selectListCountSelective(Company temp);
	
	// add 通过用户返回用户对应所以的三级公司	 
	public List<Map<String,String>> selectCompany1ByUser(String loginId); 
	
	//通过companyid查询三级公司
	public List<Map<String,String>> selectCompany1ById(Integer companyId);
}