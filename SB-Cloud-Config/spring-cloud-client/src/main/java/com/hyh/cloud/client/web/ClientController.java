package com.hyh.cloud.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyh.cloud.client.domain.Message;
import com.hyh.cloud.client.domain.MessageAcknowledgement;
import com.hyh.cloud.client.feign.ServiceClient;
import com.hyh.cloud.client.service.HelloService;

@RestController
public class ClientController {
	@Autowired
	@Qualifier("hystrixServiceClient")
	private ServiceClient serviceClient;
	@Autowired
	private HelloService service;

	@RequestMapping("/test")
	public MessageAcknowledgement sendMessage() {
		Message message = new Message("1", "2");
		System.out.println(message);
		return serviceClient.sendMessage(message);
	}

	@RequestMapping("/")
	public String hello() {
		return service.hello();
	}
}
