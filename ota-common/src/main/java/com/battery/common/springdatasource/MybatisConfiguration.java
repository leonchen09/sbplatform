package com.battery.common.springdatasource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.battery.common.utils.SpringContextHolder;

@Configuration
@AutoConfigureAfter({ DataSourceConfiguration.class })
@DependsOn("springContextHolder")
public class MybatisConfiguration extends MybatisAutoConfiguration {
	
	public MybatisConfiguration(MybatisProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider,
			ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider,
			ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {
		super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider);
	}

	private static final Logger logger = LoggerFactory.getLogger(MybatisConfiguration.class);
	
    @Value("${spring.datasource.readSize}")
    private String dataSourceSize;
    
    @Bean
    public SqlSessionFactory sqlSessionFactorys() throws Exception {
    	logger.info("-------------------- 重载父类 sqlSessionFactory init ---------------------");
//        return super.sqlSessionFactory(roundRobinDataSouceProxy());//多数据源切换
    	return super.sqlSessionFactory(SpringContextHolder.getBean("dataSource"));//单一数据源
    }

    /**
     * 有多少个数据源就要配置多少个bean
     * @return
     */
//    @Bean
//    public AbstractRoutingDataSource roundRobinDataSouceProxy() {
//        int size = Integer.parseInt(dataSourceSize);
//        MyAbstractRoutingDataSource proxy = new MyAbstractRoutingDataSource(size);
//        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
//        DataSource writeDataSource = SpringContextHolder.getBean("writeDataSource");
//        // 写
//        targetDataSources.put(DataSourceType.write.getType(), writeDataSource);
//
//        for (int i = 0; i < size; i++) {
//            targetDataSources.put(i, SpringContextHolder.getBean("readDataSource" + (i + 1)));
//        }
//        proxy.setDefaultTargetDataSource(writeDataSource);
//        proxy.setTargetDataSources(targetDataSources);
//        return proxy;
//    }

}