package com.lottery.front.control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class FirstController {
	@RequestMapping(value = "/")
	String home() {
		return "helloworld";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FirstController.class, args);
	}
}