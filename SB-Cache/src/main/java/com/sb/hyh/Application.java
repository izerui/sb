package com.sb.hyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class Application {

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("books");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
