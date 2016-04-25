package com.sb.hyh.web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.hyh.vo.DemoResponseBody;

@RestController
public class DemoController {

	@RequestMapping(value = { "/", "/index", "/index.htm" })
	public HttpEntity<DemoResponseBody> ok() {
		DemoResponseBody body = DemoResponseBody.builder().name("Name").descriptions("Descriptions").build();
		return new ResponseEntity<DemoResponseBody>(body, HttpStatus.OK);
	}
}
