package com.sb.hyh.web;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController implements EnvironmentAware {

	@Override
	public void setEnvironment(Environment environment) {
		String s = environment.getProperty("JAVA_HOME");
		System.out.println(s);
	}

	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("hello");
		return "Hello Spring-Boot";
	}
}