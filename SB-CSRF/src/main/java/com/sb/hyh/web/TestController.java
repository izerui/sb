package com.sb.hyh.web;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	protected Logger logger = Logger.getLogger(TestController.class.getName());

	@RequestMapping("/test")
	public String greeting() {
		return "hello world";
	}
}
