package com.sb.hyh.web;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局错误处理控制器
 */
@RestController
public class GlobalErrorController implements ErrorController {
	private static final String ERROR_PATH = "/error";

	@RequestMapping(value = ERROR_PATH)
	public String handleError() {
		return "/jsp/404";
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
}
