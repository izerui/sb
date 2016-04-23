package com.lottery.front.control;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexControl {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private HttpSession session;

	/**
	 * 跳转登录页面
	 */
	@RequestMapping(value = { "login", "/" }, method = RequestMethod.GET)
	public String index() {
		logger.info("首页");
		return "front/index.jsp";
	}

	/**
	 * 首页功能：开奖结果，滚动图，系统公告，投注模块（未注册提示注册）
	 */
	@RequestMapping("user/home")
	public String home() {
		return "user/home.jsp";
	}
}
