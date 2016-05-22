package com.hyh.cloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
}
