package com.battery.common.springdatasource;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * 单一数据源
 * @author leon
 *
 */

@Configuration
public class SingleDataSourceConfiguration {
	private static final Logger logger = LoggerFactory.getLogger(SingleDataSourceConfiguration.class);
	
	@Value("${spring.datasource.type}")
	private Class<? extends DataSource> dataSourceType;
	
	@Bean(name = "dataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource writeDataSource() {
		logger.debug("create datasource.");
		DruidDataSource dataSource = DruidDataSourceBuilder.create().build();;
		return dataSource;
	}

}
