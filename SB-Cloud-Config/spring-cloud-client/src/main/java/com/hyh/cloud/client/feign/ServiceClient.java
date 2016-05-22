package com.hyh.cloud.client.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyh.cloud.client.domain.Message;
import com.hyh.cloud.client.domain.MessageAcknowledgement;

@FeignClient("cloudservice")
public interface ServiceClient {
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/message", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	MessageAcknowledgement sendMessage(@RequestBody Message message);
}