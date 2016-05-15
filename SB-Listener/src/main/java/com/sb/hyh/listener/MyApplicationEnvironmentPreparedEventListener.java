package com.sb.hyh.listener;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

/**
 * 配置环境事件监听:Enviroment准备完毕,上下文context没有创建
 */
public class MyApplicationEnvironmentPreparedEventListener
		implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
	private Logger logger = LoggerFactory.getLogger(MyApplicationEnvironmentPreparedEventListener.class);

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		ConfigurableEnvironment envi = event.getEnvironment();
		MutablePropertySources mps = envi.getPropertySources();
		if (mps != null) {
			Iterator<PropertySource<?>> iter = mps.iterator();
			while (iter.hasNext()) {
				PropertySource<?> ps = iter.next();
				logger.info("ps.getName:{};ps.getSource:{};ps.getClass:{}", ps.getName(), ps.getSource(),
						ps.getClass());
			}
		}
		logger.info("==MyApplicationEnvironmentPreparedEventListener==");
	}
}
