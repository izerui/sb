package com.sb.hyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
// 1分钟失效,两种方式
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60)
public class Application {

	// @Bean
	// @Order(Ordered.HIGHEST_PRECEDENCE)
	// public EmbeddedServletContainerCustomizer servletContainerCustomizer() {
	// return new SessionTimeoutEmbeddedServletContainerCustomizer();
	// }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
