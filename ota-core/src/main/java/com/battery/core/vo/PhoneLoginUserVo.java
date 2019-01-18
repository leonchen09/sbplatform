package com.battery.core.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class PhoneLoginUserVo {

	@NotBlank
	@ApiModelProperty(value = "电话", example = "电话", required = true)
	private String userPhone;
	
	@NotBlank
	@ApiModelProperty(value = "密码", example = "密码", required = true)
	private String userPassword;

	@NotBlank
	@ApiModelProperty(value = "验证码", example = "验证码", required = true)
	private String verificationCode;

	@NotNull
	@ApiModelProperty(value = "用户类型:1管理后台，2客户，3app", required = true)
	private Integer userType;

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
