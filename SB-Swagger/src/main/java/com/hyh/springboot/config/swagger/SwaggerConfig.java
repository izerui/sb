//package com.hyh.springboot.config.swagger;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@ComponentScan(basePackages = "com.hyh.springboot")
//@EnableWebMvc
//@EnableSwagger2 // Loads the spring beans required by the framework
//@Import(SwaggerUiConfiguration.class)
//public class SwaggerConfig {
//    @Bean
//    ApiInfo apiInfo() {
//        ApiInfo apiInfo = new ApiInfo("Hong-SpringBoot API", "服务API方法定义", "1.0.0", "", "apiteam@metlife.com",
//                "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0.html");
//        return apiInfo;
//    }
//
//    @Bean
//    public Docket customImplementation() {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
//    }
//}