package com.sb.hyh.initialization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * data source,rpc服务等
 */
@Component
public class StartupRunner implements CommandLineRunner {
	protected final Logger logger = LoggerFactory.getLogger(StartupRunner.class);

	/**
	 * 最好利用try/catch语句处理可能遇到的异常
	 */
	@Override
	public void run(String... strings) {
		try {
			logger.info("hello");

			// RestTemplate restTemplate = new RestTemplate();
			// User user =
			// restTemplate.getForObject("http://localhost:8080/test",
			// User.class);
			// logger.info(user.toString());

			// Clique[] cliqueList =
			// restTemplate.getForObject("http://localhost:8080/cliques",JsonResponse.class).getEmbedded().getCliques();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 去掉@Component,在Application
	 */
	// @Bean
	// public StartupRunner schedulerRunner() {
	// return new StartupRunner();
	// }
}