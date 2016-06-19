package com.sb.hyh.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sb.hyh.exception.RestException;
import com.sb.hyh.vo.Response;

/**
 * 异常捕获
 */
@ControllerAdvice
public class RestExceptionHandler {
	private static final Logger logger = Logger.getLogger(RestExceptionHandler.class);

	/**
	 * REST接口异常
	 */
	@ResponseBody
	@ExceptionHandler(RestException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Response handleRestException(HttpServletRequest request, RestException ex) {
		logger.error("发生业务异常", ex);
		return new Response(ex.getCode(), ex.getMessage());
	}
}
