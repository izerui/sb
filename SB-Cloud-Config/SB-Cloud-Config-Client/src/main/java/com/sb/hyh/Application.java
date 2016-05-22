package com.sb.hyh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:8080/refresh
 * 
 * http://localhost:8080/env:得到所有配置信息
 */
@EnableAutoConfiguration
@ComponentScan
@RestController
@RefreshScope
public class Application {
	@Value("${foo:World!}")
	String name;

	@RequestMapping("/")
	public String home() {
		return "Hello " + name;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
