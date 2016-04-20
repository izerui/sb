package com.sb.hyh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.hyh.component.ArchaiusZkConfig;
import com.sb.hyh.service.TestService;

@RestController
public class TestController {
	@Autowired
	public TestService demoService;
	@Autowired
	public ArchaiusZkConfig archaiusZkConfig;

	@RequestMapping("/msg")
	public String getMsgFromConfig() {
		return demoService.getMsg();
	}

	@RequestMapping("/msg2")
	public String getMsgDynamic() {
		return archaiusZkConfig.getDynamicUpdate();
	}
}
