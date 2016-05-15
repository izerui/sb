package com.sb.hyh.listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * 启动异常时执行事件
 */
public class MyApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {

	@Override
	public void onApplicationEvent(ApplicationFailedEvent event) {
		Throwable throwable = event.getException();
		handleThrowable(throwable);
	}

	/**
	 * 处理异常
	 */
	private void handleThrowable(Throwable throwable) {
	}
}