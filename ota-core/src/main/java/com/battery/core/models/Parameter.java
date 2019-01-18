package com.battery.core.models;


import com.battery.common.utils.StringUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class was generated by Bill Generator.
 * This class corresponds to the database table parameters  
 *
 * @zdmgenerated 2017-28-20 11:28
 */
@ApiModel(value = "Parameter", description = "Parameter描述")
public class Parameter {
	/**
	 * This field corresponds to the database column parameters.parameter_code  
	 */
	@ApiModelProperty(value = "pk", example = "pk", required = true)
	private String parameterCode;

	/**
	 * This field corresponds to the database column parameters.parameter_value  
	 */
	@ApiModelProperty(value = "parameterValue", example = "parameterValue", required = false)
	private String parameterValue;

	/**
	 * This field corresponds to the database column parameters.parameter_desc  
	 */
	@ApiModelProperty(value = "parameterDesc", example = "parameterDesc", required = false)
	private String parameterDesc;
	//参数类型
	private String parameterCategory;
	
	public String getParameterCategory() {
		return parameterCategory;
	}

	public void setParameterCategory(String parameterCategory) {
		this.parameterCategory = parameterCategory;
	}

	/**
	 * This method returns the value of the database column parameters.parameter_code  
	 * @return the value of parameters.parameter_code
	 */
	public String getParameterCode() {
		return parameterCode;
	}

	/**
	 * This method sets the value of the database column parameters.parameter_code  
	 * @param parameterCode the value for parameters.parameter_code
	 */
	public void setParameterCode(String parameterCode) {
		this.parameterCode = parameterCode == null ? null : parameterCode.trim();
	}

	/**
	 * This method returns the value of the database column parameters.parameter_value  
	 * @return the value of parameters.parameter_value
	 */
	public String getParameterValue() {
		return parameterValue;
	}

	/**
	 * This method sets the value of the database column parameters.parameter_value  
	 * @param parameterValue the value for parameters.parameter_value
	 */
	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}
	
	/**
	 * This method returns the value of the database column parameters.parameter_desc  
	 * @return the value of parameters.parameter_desc
	 */
	public String getParameterDesc() {
		return parameterDesc;
	}

	/**
	 * This method sets the value of the database column parameters.parameter_desc  
	 * @param parameterDesc the value for parameters.parameter_desc
	 */
	public void setParameterDesc(String parameterDesc) {
		this.parameterDesc = StringUtils.isNull(parameterDesc) ? null : parameterDesc.trim();
	}
}