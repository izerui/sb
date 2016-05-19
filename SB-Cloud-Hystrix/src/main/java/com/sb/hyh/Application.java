package com.sb.hyh;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * http://localhost:9999/call
 * 
 * http://localhost:9999/hystrix.stream获取dashboard信息,默认最大打开5个终端获取监控信息
 */
@SpringBootApplication
// 启用hystrix
@EnableCircuitBreaker
// 启动对hystrix的监控
@EnableHystrixDashboard
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
}
