package com.sb.hyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ServletComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * 不用@ServletComponentScan和@WebServlet
	 */
	// @Bean
	// public ServletRegistrationBean servletRegistrationBean() {
	// return new ServletRegistrationBean(new MyServlet(), "/xs/*");
	// }

	/**
	 * 修改DispatcherServlet默认配置
	 */
	// @Bean
	// public ServletRegistrationBean dispatcherRegistration(DispatcherServlet
	// dispatcherServlet) {
	// ServletRegistrationBean registration = new
	// ServletRegistrationBean(dispatcherServlet);
	// registration.getUrlMappings().clear();
	// registration.addUrlMappings("*.do");
	// registration.addUrlMappings("*.json");
	// return registration;
	// }
}
