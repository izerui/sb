package com.sb.hyh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 依赖服务
 */
@Service
public class HystrixService {
	@Autowired
	private CallDependencyService dependencyService;

	public String callDependencyService() {
		return dependencyService.mockGetUserInfo();
	}
}
