package com.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.wechat")
public class WeChatApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WeChatApplication.class, args);
    }
}