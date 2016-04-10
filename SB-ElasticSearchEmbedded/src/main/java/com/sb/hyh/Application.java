package com.sb.hyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan
@ComponentScan(basePackages = "com.sb.hyh")
public class Application {

	public static void main(String[] args) throws Exception {
		// SpringApplication.run(Application.class, "--debug");

		SpringApplication.run(Application.class, args);
	}
}