package com.battery.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="verificationCode")
public class VerificationCodeProperties {
	// 过期时间
	public Integer expiretime;

	// 重发间隔时间
	public Integer intervaltime;

	// appid
	public Integer appid;

	// appkey
	public String appkey;

	// 发送模板
	public String content;

	public Integer getExpiretime() {
		return expiretime;
	}

	public void setExpiretime(Integer expiretime) {
		this.expiretime = expiretime;
	}

	public Integer getIntervaltime() {
		return intervaltime;
	}

	public void setIntervaltime(Integer intervaltime) {
		this.intervaltime = intervaltime;
	}

	public Integer getAppid() {
		return appid;
	}

	public void setAppid(Integer appid) {
		this.appid = appid;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
