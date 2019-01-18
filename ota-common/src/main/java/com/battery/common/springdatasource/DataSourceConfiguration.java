package com.battery.common.springdatasource;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.battery.common.utils.DBPwdUtil;

@Configuration
public class DataSourceConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);
	
	@Value("${spring.datasource.type}")
	private Class<? extends DataSource> dataSourceType;
	
	

	@Autowired
	@Qualifier("dbPasswordCallback")
	private DBPwdUtil dBPwdUtil;
	
//	@Bean(name = "writeDataSource")
//	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.master")
	public DataSource writeDataSource() {
		logger.info("-------------------- writeDataSource init ---------------------");
		DruidDataSource dataSource = DruidDataSourceBuilder.create().build();;
		dataSource.setPasswordCallback(dBPwdUtil);
		return dataSource;
	}

	/**
	 * 有多少个从库就要配置多少个
	 * 
	 * @return
	 */
//	@Bean(name = "readDataSource1")
	@ConfigurationProperties(prefix = "spring.datasource.slave1")
	public DataSource readDataSourceOne() {
		logger.info("-------------------- readDataSourceOne init ---------------------");
		DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
		dataSource.setPasswordCallback(dBPwdUtil);
		return dataSource;
	}
}