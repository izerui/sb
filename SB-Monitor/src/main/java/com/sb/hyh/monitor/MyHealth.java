//package com.sb.hyh.monitor;
//
//import org.springframework.boot.actuate.health.Health;
//import org.springframework.boot.actuate.health.HealthIndicator;
//import org.springframework.stereotype.Component;
//
///**
// * 健康检查协议
// * 
// * http://localhost:8888/health
// */
//@Component
//public class MyHealth implements HealthIndicator {
//
//	@Override
//	public Health health() {
//		// some logic check tair
//		// some logic check tfs
//		return new Health.Builder().withDetail("tair", "timeout").withDetail("tfs", "ok").status("500").down().build();
//	}
//}