package com.sb.hyh.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 上下文创建完成后执行的事件监听器:上下文context创建完成,bean没有完全加载完成
 */
public class MyApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {
	private Logger logger = LoggerFactory.getLogger(MyApplicationPreparedEventListener.class);

	@Override
	public void onApplicationEvent(ApplicationPreparedEvent event) {
		ConfigurableApplicationContext cac = event.getApplicationContext();
		passContextInfo(cac);
	}

	/**
	 * 传递上下文
	 */
	private void passContextInfo(ApplicationContext cac) {
		logger.info("==MyApplicationPreparedEventListener==");
	}
}