package com.sb.hyh.web;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	/**
	 * /WEB-INF/jsp/index.jsp
	 */
	@RequestMapping(value = { "/", "/index" })
	public String index(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "message");
		return "index";
	}

	/**
	 * /WEB-INF/jsp/page/page.jsp
	 */
	@RequestMapping("/page1")
	public ModelAndView page1() {
		ModelAndView mav = new ModelAndView("page/page1");
		mav.addObject("content", "content");
		return mav;
	}

	/**
	 * /WEB-INF/jsp/page/page.jsp
	 */
	@RequestMapping("/page2")
	public String page2(Model model) {
		model.addAttribute("content", "content");
		return "page/page1";
	}

	@RequestMapping("/welcome")
	public String welcome1() {
		return "welcome";
	}
}