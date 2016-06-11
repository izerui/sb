package com.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class WeChatApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WeChatApplication.class, args);
	}
}