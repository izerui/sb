package com.sb.hyh.web;

import java.util.Date;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	private String message = "Hello World";

	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		System.out.println("/");
		model.put("time", new Date());
		model.put("message", this.message);
		return "index";
	}

	@RequestMapping("/login")
	public String login(Map<String, Object> model) {
		System.out.println("/initlogin");
		model.put("time", new Date());
		model.put("message", this.message);
		return "login";
	}

	@RequestMapping("/judge")
	public String welcome(@RequestParam String username, @RequestParam String password, Map<String, Object> model) {
		try {
			AuthenticationToken token = new UsernamePasswordToken(username, password, true);
			Subject currentUser = SecurityUtils.getSubject();
			currentUser.login(token);
			return "welcome";
		} catch (Exception e) {
			return "login";
		}
	}
}
