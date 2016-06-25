package com.sb.hyh.aop;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class ServiceMonitor {

	@Before("execution(* com.sb.hyh..*Controller.*(..))")
	public void logAccess(JoinPoint joinPoint) {
		System.out.println("Completed: " + joinPoint);

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String remoteAddr = getIpAddress(request);
		String userAgent = request.getHeader("user-agent");
		String requestUri = request.getRequestURI();
		String method = request.getMethod();

		Map<String, String[]> paramMap = request.getParameterMap();
		StringBuffer params = new StringBuffer();
		if (paramMap != null && paramMap.size() > 0) {
			for (Map.Entry<String, String[]> param : paramMap.entrySet()) {
				if ("".equals(params.toString())) {
					params.append(param.getKey() + "=");
				} else {
					params.append("&" + param.getKey() + "=");
				}

				String paramValue = "";
				if (param.getValue() != null && param.getValue().length > 0) {
					paramValue = param.getValue()[0];
				}

				// 屏蔽密码获取
				if (!"password".equals(param.getKey())) {
					params.append(paramValue);
				}
			}
		}

		System.out.println("ip address:" + remoteAddr);
		System.out.println("useragent:" + userAgent);
		System.out.println("url:" + requestUri);
		System.out.println("request method:" + method);
		System.out.println("method params:" + params.toString());
		System.out.println("---------------------------------");
	}

	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个ip值,第一个ip才是真实ip
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}
}
