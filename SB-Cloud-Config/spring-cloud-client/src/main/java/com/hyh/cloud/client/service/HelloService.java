package com.hyh.cloud.client.service;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@HystrixCommand(fallbackMethod = "fallback")
	public String hello() {
		return "Hello World";
	}

	public String fallback() {
		return "Fallback";
	}
}
