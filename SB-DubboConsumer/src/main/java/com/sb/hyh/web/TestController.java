package com.sb.hyh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.hyh.provider.DemoService;

@RestController
public class TestController {
	@Autowired
	private DemoService demoService;

	@RequestMapping("/test")
	public void test() {
		String hello = demoService.sayHello("world");
		System.out.println(hello);
	}

	@RequestMapping("/test2")
	public void test2() {
		System.out.println("test2");
	}
}
