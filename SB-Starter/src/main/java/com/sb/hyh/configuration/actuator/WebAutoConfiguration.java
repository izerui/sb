package com.sb.hyh.configuration.actuator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = { "com.sb.hyh" })
public class WebAutoConfiguration {

	/**
	 * addViewController方法不支持placeholder的解析,故在这里用变量解析出来
	 */
	@Value("${actuator.web.base:}")
	String actuatorBase;

	// @Bean
	// public ActuatorNavController actuatorNavController(){
	// return new ActuatorNavController();
	// }

	@Bean
	public WebMvcConfigurerAdapter configStaticMapping() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				// 配置跳转
				registry.addViewController(actuatorBase + "/nav").setViewName("forward:/static/nav.html");
			}

			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
			}
		};
	}
}
