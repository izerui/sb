package com.sb.hyh.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sb.hyh.exception.RestException;

@Controller
public class TestController {

	@ResponseBody
	@RequestMapping(value = "/test")
	public String test() {
		throw new RestException();
	}
}
