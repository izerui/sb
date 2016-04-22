package com.lottery.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.lottery.interceptor.UserSecurityInterceptor;

@EnableScheduling
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebAppConfig.class);
	}

	/**
	 * 配置拦截器
	 */
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserSecurityInterceptor()).addPathPatterns("/user/**");
	}

	/**
	 * spring boot 定时任务
	 */
	@Scheduled(cron = "0 0/10 * * * ?")
	public void timer() {

	}
}