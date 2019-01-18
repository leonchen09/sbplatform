package com.battery.common.springdatasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.battery.common.utils.DBPwdUtil;

@Configuration
public class DbPasswordConfig {
	
	//passwordcallbak 只配置了一个
	@Bean(name="dbPasswordCallback")
	public DBPwdUtil dbPasswordCallbackMaster() {
		return new DBPwdUtil();
	}
}
