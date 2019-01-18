package com.battery.core.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
/**
 * 公司
 * @author 
 *
 */

public class Company {
	/**
	 * This field corresponds to the database column companies.company_id  
	 */
	@ApiModelProperty(value = "pk", required = true)
	private Integer companyId;

	/**
	 * This field corresponds to the database column companies.company_name  
	 */
	@ApiModelProperty(value = "companyName", example = "companyName", required = false)
	private String companyName;

	/**
	 * This field corresponds to the database column companies.create_time  创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	/**
	 * This field corresponds to the database column companies.create_id  
	 */
	@ApiModelProperty(value = "createId", required = false)
	private Integer createId;

	/**
	 * This field corresponds to the database column companies.create_name  
	 */
	@ApiModelProperty(value = "createName", example = "createName", required = false)
	private String createName;

	/**
	 * This field corresponds to the database column companies.parent_company_id  
	 */
	@ApiModelProperty(value = "parentCompanyId", required = false)
	private Integer parentCompanyId;

	/**
	 * This field corresponds to the database column companies.company_level  
	 */
	@ApiModelProperty(value = "companyLevel", required = false)
	private Integer companyLevel;

	/**
	 * This method returns the value of the database column companies.company_id  
	 * @return the value of companies.company_id
	 */
	public Integer getCompanyId() {
		return companyId;
	}

	/**
	 * This method sets the value of the database column companies.company_id  
	 * @param companyId the value for companies.company_id
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * This method returns the value of the database column companies.company_name  
	 * @return the value of companies.company_name
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * This method sets the value of the database column companies.company_name  
	 * @param companyName the value for companies.company_name
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName == null ? null : companyName.trim();
	}

	/**
	 * This method returns the value of the database column companies.create_time  创建时间
	 * @return the value of companies.create_time
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method sets the value of the database column companies.create_time  创建时间
	 * @param createTime the value for companies.create_time
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method returns the value of the database column companies.create_id  
	 * @return the value of companies.create_id
	 */
	public Integer getCreateId() {
		return createId;
	}

	/**
	 * This method sets the value of the database column companies.create_id  
	 * @param createId the value for companies.create_id
	 */
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	/**
	 * This method returns the value of the database column companies.create_name  
	 * @return the value of companies.create_name
	 */
	public String getCreateName() {
		return createName;
	}

	/**
	 * This method sets the value of the database column companies.create_name  
	 * @param createName the value for companies.create_name
	 */
	public void setCreateName(String createName) {
		this.createName = createName == null ? null : createName.trim();
	}

	/**
	 * This method returns the value of the database column companies.parent_company_id  
	 * @return the value of companies.parent_company_id
	 */
	public Integer getParentCompanyId() {
		return parentCompanyId;
	}

	/**
	 * This method sets the value of the database column companies.parent_company_id  
	 * @param parentCompanyId the value for companies.parent_company_id
	 */
	public void setParentCompanyId(Integer parentCompanyId) {
		this.parentCompanyId = parentCompanyId;
	}

	/**
	 * This method returns the value of the database column companies.company_level  
	 * @return the value of companies.company_level
	 */
	public Integer getCompanyLevel() {
		return companyLevel;
	}

	/**
	 * This method sets the value of the database column companies.company_level  
	 * @param companyLevel the value for companies.company_level
	 */
	public void setCompanyLevel(Integer companyLevel) {
		this.companyLevel = companyLevel;
	}
}
