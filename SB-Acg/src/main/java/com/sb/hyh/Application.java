package com.sb.hyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"com.xuebangsoft.eduboss.tools", "com.xuebangsoft.core.webboot"})
//@EntityScan("com.xuebangsoft.eduboss.tools.entity")
//@EnableJpaRepositories("com.xuebangsoft.eduboss.tools.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
