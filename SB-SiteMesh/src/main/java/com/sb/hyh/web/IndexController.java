package com.sb.hyh.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public ModelAndView test() {
		return new ModelAndView("index");
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
