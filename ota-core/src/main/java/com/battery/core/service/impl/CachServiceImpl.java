package com.battery.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.battery.core.models.Company;
import com.battery.core.service.CachService;
import com.battery.core.service.CompanyService;



@Service
public class CachServiceImpl implements CachService {
	@Autowired
	CompanyService companySer;
	
	@Override
	public Company getCompanyById(Integer companyId){
		return companySer.selectByPrimaryKey(companyId);
	}
}
