package com.lottery.admin.control;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private HttpSession session;

	@RequestMapping("admin/login")
	public String login() {
		return "admin/login";
	}

	@RequestMapping("admin/index")
	public String index() {
		return "admin/index";
	}

	@RequestMapping("admin/main")
	public String main() {
		return "admin/main";
	}

	@RequestMapping("admin/article")
	public String article() {
		return "admin/article/article";
	}

	@RequestMapping("admin/banner_list")
	public String banner_list() {
		return "admin/banner/banner_list";
	}

	@RequestMapping("admin/doctor_edit")
	public String doctor_edit() {
		return "admin/doctor/doctor_edit";
	}

	@RequestMapping("admin/system_info")
	public String system_info() {
		return "admin/info/system_info";
	}

	@RequestMapping("admin/news_edit")
	public String news_edit() {
		return "admin/news/news_edit";
	}

	@RequestMapping("admin/news_list")
	public String news_list() {
		return "admin/news/news_list";
	}

	@RequestMapping("admin/city")
	public String city() {
		return "admin/template/city";
	}

	@RequestMapping("admin/user_list")
	public String user_list() {
		return "admin/user/user_list";
	}
}
