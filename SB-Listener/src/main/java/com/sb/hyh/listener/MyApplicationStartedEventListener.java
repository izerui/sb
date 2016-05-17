package com.sb.hyh.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * 启动监听类:启动开始时执行的事件
 */
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

	private Logger logger = LoggerFactory.getLogger(MyApplicationStartedEventListener.class);

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		SpringApplication app = event.getSpringApplication();
		app.setShowBanner(false);
		logger.info("==MyApplicationStartedEventListener==");
		System.out.println("==MyApplicationStartedEventListener==");
	}
}