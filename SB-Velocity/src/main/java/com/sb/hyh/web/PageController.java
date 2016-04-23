package com.sb.hyh.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("Hello Spring-Boot");
		return "Hello Spring-Boot";
	}
}