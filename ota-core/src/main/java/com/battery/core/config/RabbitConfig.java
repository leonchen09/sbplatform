package com.battery.core.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ConfigurationProperties(prefix = "rabbit")
@ConditionalOnProperty(value = "rabbit.host")
public class RabbitConfig {

	@Value("${rabbit.host}")
	private String host;
	@Value("${rabbit.port}")
	private int port;
	@Value("${rabbit.username}")
	private String username;
	@Value("${rabbit.password}")
	private String password;
	@Value("${rabbit.virtual-host}")
	private String virtuaHost;
	@Value("${rabbit.publisher-confirms}")
	private Boolean publisherConfirms;

	@Bean
	public ConnectionFactory connectionFactory() {
		// 创建连接工厂
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setHost(host);
		connectionFactory.setPort(port);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		connectionFactory.setPublisherConfirms(publisherConfirms); // enable confirm mode
		connectionFactory.setVirtualHost(virtuaHost);
		connectionFactory.setPublisherReturns(true);
		return connectionFactory;
	}

	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		return template;
	}

}
