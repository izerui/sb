//package com.sb.hyh;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.bind.RelaxedPropertyResolver;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
///**
// * 读取环境变量
// */
//@Configuration
//public class MyWebAppConfigurer implements EnvironmentAware {
//	private static final Logger logger = LoggerFactory.getLogger(MyWebAppConfigurer.class);
//	private RelaxedPropertyResolver propertyResolver;
//
//	@Value("${spring.datasource.url:default}")
//	private String myUrl;
//
//	@Override
//	public void setEnvironment(Environment env) {
//		logger.info(env.getProperty("JAVA_HOME"));
//
//		logger.info(env.getProperty("spring.datasource.url"));
//		propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
//		logger.info(propertyResolver.getProperty("url"));
//
//		logger.info(myUrl);
//	}
//}