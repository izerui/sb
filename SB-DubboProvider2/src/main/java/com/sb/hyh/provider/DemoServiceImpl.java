package com.sb.hyh.provider;

import com.sb.hyh.dubbo.intf.DemoService;

public class DemoServiceImpl implements DemoService {

	@Override
	public String sayHello(String name) {
		return "Hello Dubbo,Hello " + name;
	}
}
