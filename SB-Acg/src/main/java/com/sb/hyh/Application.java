package com.sb.hyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

//@SpringBootApplication
//@RestController
//@ComponentScan({"com.xuebangsoft.eduboss.tools", "com.xuebangsoft.core.webboot"})
//@EntityScan("com.xuebangsoft.eduboss.tools.entity")
//@EnableJpaRepositories("com.xuebangsoft.eduboss.tools.dao")
//@EnableScheduling
//public class Start {
//
//    @RequestMapping("/")
//    String home() {
//        return "Hello World!";
//    }
//
//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Start.class, args);
//        System.out.println("try to access : http://localhost:8080/user/save?username=admin&password=123456");
//        System.out.println("try to access : http://localhost:8080/user/page?search_LIKE_username=d&search_LLIKE_password=123&pageNumber=1&pageSize=5&sorts[0].field=username&sorts[1].field=password&sorts[1].order=asc");
//    }
//}
