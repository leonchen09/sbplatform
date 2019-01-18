package com.battery.common.springdatasource;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class DataSourceAop {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceAop.class);

	@Pointcut("execution(* com.battery.*.service.impl.*.*(..))")  
    public void serviceimpl(){}
	
    /**
     * 在进入Service方法之前执行
     * 
     * @param point 切面对象
     */
	@Before("serviceimpl()") 
	@Order(-9999)
    public void before(JoinPoint point) {
        // 获取到当前执行的方法名
        String methodName = point.getSignature().getName();
        String declaringTypeName = point.getSignature().getDeclaringTypeName();
        if (isSlave(methodName)) {//只读方法
        	if(StringUtils.isBlank(DataSourceContextHolder.getJdbcType())) {
	            // 标记为读库
        		DataSourceContextHolder.read();
	        	logger.debug("进入slaver读库：方法是"+declaringTypeName+"-->"+methodName);
        	}
        } else {
            // 标记为写库
        	DataSourceContextHolder.write();
        	logger.debug("进入master写库：方法是"+declaringTypeName+"-->"+methodName);
        }
    }

    /**
     * 判断是否为读库
     * 
     * @param methodName
     * @return
     */
    private Boolean isSlave(String methodName) {
        // 方法名以query、find、get开头的方法名走从库
        Boolean falg= StringUtils.startsWithAny(methodName, "find", "get","select");
        return falg;
    }
    
}