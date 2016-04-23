package com.sb.hyh.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LogDemoService {
	private static final Logger logger = LoggerFactory.getLogger(LogDemoService.class);

	public void generateLog() {
		logger.info("hello:{}", UUID.randomUUID().toString());
	}
}
