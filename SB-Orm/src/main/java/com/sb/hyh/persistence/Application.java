package com.sb.hyh.persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories
@EnableAutoConfiguration
@PropertySource({ "classpath:db-config.properties" })
public class Application {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "bpp-service-pm");

		SpringApplication.run(Application.class, args);
	}
}
