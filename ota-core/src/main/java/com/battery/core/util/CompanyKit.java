package com.battery.core.util;

import com.battery.common.utils.SpringContextHolder;
import com.battery.core.models.Company;
import com.battery.core.service.CompanyService;

public class CompanyKit {

	/**
	 * 根据id获取company对象
	 * @param companyId
	 * @return
	 */
	public static Company getCompanyById(Integer companyId) {
		if(companyId != null) {
			return SpringContextHolder.getBean(CompanyService.class).selectByPrimaryKey(companyId);
		}
		return null;
	}
	
	/**
	 * 根据id获取company -> companyName
	 * @param companyId
	 * @return
	 */
	public static String getCompanyNameById(Integer companyId) {
		Company company = getCompanyById(companyId);
		if(company != null) {
			return company.getCompanyName();
		}
		return null;
	}
}
