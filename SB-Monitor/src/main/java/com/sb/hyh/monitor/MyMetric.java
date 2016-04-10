//package com.sb.hyh.monitor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.actuate.metrics.CounterService;
//import org.springframework.boot.actuate.metrics.GaugeService;
//import org.springframework.stereotype.Component;
//
///**
// * 收集实时的业务数据，例如每分钟用户登陆数量、每分钟文件同步数量、实时的缓存命中率
// * 
// * http://localhost:8888/metrics
// */
//@Component
//public class MyMetric {
//	private final CounterService counterService;
//	private final GaugeService gaugeService;
//
//	@Autowired
//	public MyMetric(CounterService counterService, GaugeService gaugeService) {
//		this.counterService = counterService;
//		this.gaugeService = gaugeService;
//	}
//
//	public void exampleCounterMethod() {
//		// 累加
//		this.counterService.increment("login.count");
//		// reset each minute
//	}
//
//	public void exampleGaugeMethod() {
//		// 保存
//		this.gaugeService.submit("cache.hit", 80.0);
//	}
//}