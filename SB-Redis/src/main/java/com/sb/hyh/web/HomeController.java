package com.sb.hyh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sb.hyh.redis.dao.RedisDao;

@Controller
public class HomeController {
	@Autowired
	private RedisDao redisDao;

	@ResponseBody
	@RequestMapping("/test")
	public void test() {
		redisDao.test();
	}
}
