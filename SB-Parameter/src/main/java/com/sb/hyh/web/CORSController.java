package com.sb.hyh.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 跨域请求
 */
@RestController
public class CORSController {

	@ResponseBody
	@RequestMapping("now")
	public String now(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		return "这是一个测试";
	}
}
