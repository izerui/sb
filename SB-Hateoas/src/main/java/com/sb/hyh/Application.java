package com.sb.hyh;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.sb.hyh.vo.Greeting;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        RestTemplate template = new RestTemplate();
        Greeting greeting = template.getForObject("http://localhost:8080/greeting?name=323", Greeting.class);
        System.out.println(greeting);
    }
}
