package com.sb.hyh.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello Spring-Boot";
	}

	@RequestMapping("/info")
	public Map<String, String> getInfo(@RequestParam String name) {
		System.out.println(name);
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		return map;
	}
}