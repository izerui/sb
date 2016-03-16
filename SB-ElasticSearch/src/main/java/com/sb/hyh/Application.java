package com.sb.hyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = { "com.sb.hyh.repository" })
@ComponentScan(basePackages = "com.sb.hyh")
public class Application {

    public static void main(String[] args) throws Exception {
        // SpringApplication.run(Application.class, "--debug");

        SpringApplication.run(Application.class, args);
    }
}