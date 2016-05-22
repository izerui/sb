package com.hyh.cloud.client.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hyh.cloud.client.domain.Message;
import com.hyh.cloud.client.domain.MessageAcknowledgement;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service("hystrixServiceClient")
public class HystrixWrappedServiceClient implements ServiceClient {

	@Autowired
	@Qualifier("serviceClient")
	private ServiceClient feignPongClient;

	@Override
	@HystrixCommand(groupKey = "serviceGroup", fallbackMethod = "fallBackCall")
	public MessageAcknowledgement sendMessage(Message message) {
		return this.feignPongClient.sendMessage(message);
	}

	public MessageAcknowledgement fallBackCall(Message message) {
		return new MessageAcknowledgement(message.getId(), message.getPayload(), "FAILED SERVICE CALL! - FALLING BACK");
	}
}
