package com.sb.hyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"cn.conac.test", "com.sb.hyh"})
@EntityScan("cn.conac.test.po")
@EnableJpaRepositories("cn.conac.test.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        System.out.println("http://localhost:8080/user/save?username=admin&password=123456");
        System.out.println("http://localhost:8080/user/all");
        System.out.println("http://localhost:8080/user/page?search_LIKE_username=d&search_LLIKE_password=123&pageNumber=1&pageSize=5&sorts[0].field=username&sorts[1].field=password&sorts[1].order=asc");
    }
}
