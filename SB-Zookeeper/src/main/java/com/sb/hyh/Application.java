package com.sb.hyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class Application {

	// @Value("${spring.cloud.zookeeper.connectString}")
	// String zkConnString;
	//
	// @Bean
	// public ZookeeperProperties zkProperties() {
	// ZookeeperProperties properties = new ZookeeperProperties();
	// properties.setConnectString(zkConnString);
	// return properties;
	// }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
