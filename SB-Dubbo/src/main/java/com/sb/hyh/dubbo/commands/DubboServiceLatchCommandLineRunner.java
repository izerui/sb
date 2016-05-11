package com.sb.hyh.dubbo.commands;

import org.springframework.boot.CommandLineRunner;

import com.hyh.lifecycles.ShutdownLatch;

public class DubboServiceLatchCommandLineRunner implements CommandLineRunner {
	private String domain;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("latch");
		ShutdownLatch latch = new ShutdownLatch(getDomain());
		latch.await();
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
}
