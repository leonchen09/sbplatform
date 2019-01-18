package com.battery.core.vo.response;

import com.battery.core.models.Company;

public class CompanyWrap extends Company{
	
	private String parentCompanyName;

	public String getParentCompanyName() {
		return parentCompanyName;
	}

	public void setParentCompanyName(String parentCompanyName) {
		this.parentCompanyName = parentCompanyName;
	}
	
}
