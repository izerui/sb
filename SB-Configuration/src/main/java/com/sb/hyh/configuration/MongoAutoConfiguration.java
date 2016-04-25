//package com.sb.hyh.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.mongo.MongoProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//
//import com.mongodb.Mongo;
//
////@Configuration注解的类等价与XML中配置beans,用@Bean标注方法等价于XML中配置的bean
//@Configuration
//@ConditionalOnClass(Mongo.class)
//// 将SpringBoot的配置文件(application.properties)中的spring.data.mongodb.*属性映射为MongoProperties并注入到MongoAutoConfiguration中
//@EnableConfigurationProperties(MongoProperties.class)
//public class MongoAutoConfiguration {
//
//	@Autowired
//	private MongoProperties properties;
//}