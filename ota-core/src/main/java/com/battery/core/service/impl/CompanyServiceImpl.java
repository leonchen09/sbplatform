package com.battery.core.service.impl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.battery.common.service.impl.BaseServiceImpl;
import com.battery.core.mapper.CompanyMapper;
import com.battery.core.mapper.UserMapper;
import com.battery.core.models.Company;
import com.battery.core.models.User;
import com.battery.core.service.CompanyService;

@Service
public class CompanyServiceImpl extends BaseServiceImpl<Company, Integer> implements CompanyService {
	@Autowired
	CompanyMapper companyMapper;
	@Autowired
	CompanyService companySer;
	
	@Autowired
	UserMapper userMapper;

	@Override
	public int selectListCountSelective(Company company) {
		return companyMapper.selectListCountSelective(company);
	}

	/**
	 * 通过用户查询出对的三级公司
	 */
	@Override
	public List<Map<String,String>> selectCompany1ByUser(String loginId) {
		//根据loginId查询user
		User user = new User();
		user.setLoginId(loginId);
		List<User> users = userMapper.selectListSelective(user);
		if(users.size() > 0) {
			user = users.get(0);
			return selectCompany1ById(user.getCompanyId());
		}
		return null;
	}

	@Override
	public List<Map<String, String>> selectCompany1ById(Integer companyId) {
		List<Map<String,String>> companyList = new ArrayList<Map<String,String>>();
		if(companyId != null) {
			Company company = companyMapper.selectByPrimaryKey(companyId);
			if(company != null ) {
				Map<String,String> map = new HashMap<>();
				if(company.getCompanyLevel() == 1) {
					map.put("company1", company.getCompanyName());
				}else if(company.getCompanyLevel() == 2) {
					Company fist = companyMapper.selectByPrimaryKey(company.getParentCompanyId());
					map.put("company1", fist.getCompanyName());
					map.put("company2", company.getCompanyName());
				}else if(company.getCompanyLevel() == 3){
					Company second = companyMapper.selectByPrimaryKey(company.getParentCompanyId());
					Company fist = companyMapper.selectByPrimaryKey(second.getParentCompanyId());
					map.put("company1", fist.getCompanyName());
					map.put("company2", second.getCompanyName());
					map.put("company3", company.getCompanyName());
				}
				
				companyList.add(map);
			}
		}
		return companyList;
	}
}