package com.sb.hyh.aop.monitor;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class ServiceMonitor {

	@Before("execution(* com.sb.hyh..*Service.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		System.out.println("Completed: " + joinPoint);
	}

	@Before("execution(* com.sb.hyh..*Controller.*(..))")
	public void logServiceAccess2(JoinPoint joinPoint) {
		System.out.println("Completed: " + joinPoint);

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		String userAgent = request.getHeader("user-agent");
		String requestUri = request.getRequestURI();
		String method = request.getMethod();

		System.out.println(userAgent);
		System.out.println(requestUri);
		System.out.println(method);
	}
}
