package com.hyh.cloud.service.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hyh.cloud.service.domain.Message;
import com.hyh.cloud.service.domain.MessageAcknowledgement;

@RestController
public class ServiceController {

	@Value("${reply.message}")
	private String message;

	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public Resource<MessageAcknowledgement> pongMessage(@RequestBody Message input) {
		System.out.println(input);
		return new Resource<>(new MessageAcknowledgement(input.getId(), input.getPayload(), message));
	}
}
