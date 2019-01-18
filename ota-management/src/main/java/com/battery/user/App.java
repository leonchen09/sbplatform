package com.battery.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = { "com.battery.common", "com.battery.core", "com.battery.user" }, exclude = {
		RabbitAutoConfiguration.class })
@MapperScan({ "com.battery.common.mapper", "com.battery.core.mapper" })
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class App {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(App.class, args);
	}
}
