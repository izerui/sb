package com.sb.hyh.filter;

import javax.servlet.Filter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilter2Configurer {
	@Bean
	public FilterRegistrationBean someFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(someFilter());
		// registration.addUrlPatterns("/url/*");
		registration.addUrlPatterns("/*");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("someFilter");
		return registration;
	}

	@Bean(name = "someFilter")
	public Filter someFilter() {
		return new MyFilter2();
	}
}
