//package com.sb.hyh.configuration;
//
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
//import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
//
//public class SessionTimeoutEmbeddedServletContainerCustomizer implements EmbeddedServletContainerCustomizer {
//
//	@Override
//	public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
//		TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) configurableEmbeddedServletContainer;
//		tomcat.setSessionTimeout(1, TimeUnit.MINUTES);
//	}
//}