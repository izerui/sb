package com.sb.hyh.web;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Value("${application.message}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		System.out.println("/sa/");
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}

	@RequestMapping("/welcome")
	public String home(Map<String, Object> model) {
		System.out.println("/sa/");
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}
}
