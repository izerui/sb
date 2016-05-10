package com.sb.hyh.filter;

import javax.validation.Validator;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class CharacterEncodingConfig {

	@Bean
	public Validator validator() {
		return new org.springframework.validation.beanvalidation.LocalValidatorFactoryBean();
	}

	@Bean(name = "characterEncodingFilter")
	public FilterRegistrationBean characterEncodingFilter() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.addInitParameter("encoding", "UTF-8");
		bean.addInitParameter("forceEncoding", "true");
		bean.setFilter(new CharacterEncodingFilter());
		bean.addUrlPatterns("/*");
		return bean;
	}
}
