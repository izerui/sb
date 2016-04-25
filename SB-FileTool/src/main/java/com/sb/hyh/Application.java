package com.sb.hyh;

import javax.servlet.MultipartConfigElement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.MimeMappings;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@EnableAutoConfiguration
@SpringBootApplication
@Configuration
@ComponentScan
public class Application implements EmbeddedServletContainerCustomizer {

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("5000MB");
		factory.setMaxRequestSize("5000MB");
		return factory.createMultipartConfig();
	}

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/upload").setViewName("upload");
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
		mappings.add("html", "text/html;charset=utf-8");
		container.setMimeMappings(mappings);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
