package com.battery.user.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.battery.user.interceptor.AuthorizationInterceptor;
import com.google.common.collect.Lists;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	private String basename = "classpath:i18n/messages";
	private String VALIDATE_MESSAGE = "classpath:validate/validatemessages";

	/**
	 * 拦截
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		String[] notInterceptUrls = {};
		AuthorizationInterceptor authorizationInterceptor = new AuthorizationInterceptor();
		authorizationInterceptor.setNotInterceptUrls(notInterceptUrls);

		List<String> interceptorUrls = Lists.newArrayList();
		interceptorUrls.add("/**");
		List<String> excludeUrls = Lists.newArrayList();
		excludeUrls.add("/v2/api-docs");
		excludeUrls.add("/error");
		excludeUrls.add("/stationInfo/fileImport");
		excludeUrls.add("/warningInfo/download");
		excludeUrls.add("/login/doLogin");
		excludeUrls.add("/login/doPhoneLogin");
		excludeUrls.add("/getCode/*");
		excludeUrls.add("/login/getCode");
		excludeUrls.add("/app/login/doLogin");
		excludeUrls.add("/app/login/getCode");
		excludeUrls.add("/app/login/updatePassword");
		registry.addInterceptor(authorizationInterceptor)
				.addPathPatterns(interceptorUrls.stream().toArray(String[]::new))
				.excludePathPatterns(excludeUrls.stream().toArray(String[]::new));
		super.addInterceptors(registry);
	}

	@Bean
	public ReloadableResourceBundleMessageSource getMessageResource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames(basename, VALIDATE_MESSAGE);
		messageSource.setCacheSeconds(5);
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		return lci;
	}

	@Bean(name = "validator")
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(getMessageResource());
		return localValidatorFactoryBean;
	}

	@Override
	public Validator getValidator() {
		return validator();
	}

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
		processor.setValidator(validator());
		return processor;
	}

	/**
	 * 替换框架json为fastjson
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		//设置local和timeZone
		JSON.defaultLocale = Locale.SIMPLIFIED_CHINESE;
		JSON.defaultTimeZone = TimeZone.getTimeZone("GMT+08:00");
		
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat, SerializerFeature.WriteDateUseDateFormat);
		// 处理中文乱码问题
		List<MediaType> fastMediaTypes = new ArrayList<>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		fastConverter.setSupportedMediaTypes(fastMediaTypes);
		fastConverter.setFastJsonConfig(fastJsonConfig);

		// 处理字符串, 避免直接返回字符串的时候被添加了引号
		StringHttpMessageConverter smc = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		converters.add(smc);

		converters.add(fastConverter);
		super.configureMessageConverters(converters);
	}
}