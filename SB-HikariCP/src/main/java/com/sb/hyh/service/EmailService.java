package com.sb.hyh.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	// @Value("${EmailQueueListener.enabled}")
	// public boolean EmailQueueListenerEnbaled;

	@PostConstruct
	public void init() {
		// 初始化队列服务
	}

	public List<String> sendMail(String title, String content, String... to) {
		return null;
	}
}
