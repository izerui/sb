package com.sb.hyh.component;

import java.util.Map;

import javax.servlet.Servlet;

import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableMap;

/**
 * 反向代理服务器：日志、缓存、身份验证
 */
@Component
public class BaiDuProxy {
	@Bean
	public Servlet baiduProxyServlet() {
		return new ProxyServlet();
	}

	@Bean
	public ServletRegistrationBean proxyServletRegistration() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(baiduProxyServlet(), "/*");
		Map<String, String> params = ImmutableMap.of("targetUri", "http://baidu.com", "log", "true");
		registrationBean.setInitParameters(params);
		return registrationBean;
	}
}
