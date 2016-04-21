package com.sb.hyh.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// registry.addResourceHandler("/pages/**").addResourceLocations("classpath:/templates/pages/");
		// registry.addResourceHandler("/bower_components/**")
		// .addResourceLocations("classpath:/templates/bower_components/");
		// registry.addResourceHandler("/dist/**").addResourceLocations("classpath:/templates/dist/");
		// registry.addResourceHandler("/less/**").addResourceLocations("classpath:/templates/less/");

		// 统一处理
		registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/");
	}
}