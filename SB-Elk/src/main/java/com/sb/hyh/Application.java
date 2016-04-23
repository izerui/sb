package com.sb.hyh;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sb.hyh.service.LogDemoService;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	@Autowired
	private LogDemoService logDemoService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		while (true) {
			logDemoService.generateLog();
			Thread.sleep(1000);
			logger.info("current thread:{},content:{}", Thread.currentThread().getName(), UUID.randomUUID().toString());
		}
	}
}
