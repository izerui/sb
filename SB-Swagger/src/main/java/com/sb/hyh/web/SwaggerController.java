package com.sb.hyh.web;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/user")
public class SwaggerController {

	@RequestMapping(value = "/demo2", method = RequestMethod.POST)
	@ApiOperation(value = "测试接口1", notes = "测试接口详细描述")
	@ResponseBody
	ModelMap getDemo(@RequestBody User user) {
		ModelMap map = new ModelMap();
		map.addAttribute("userId", 111);
		map.addAttribute("userName", "kl博客");
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/demo3", method = RequestMethod.POST)
	@ApiOperation(value = "测试接口2", notes = "测试接口详细描述", code = 200, produces = "application/json")
	public ModelMap getDemoa(@RequestParam("name") String demoName, @RequestParam String content) {
		ModelMap map = new ModelMap();
		map.addAttribute("result", demoName + "AAA");
		return map;
	}

	@ResponseBody
	// 忽略接口
	@ApiIgnore
	@RequestMapping(value = "/demo4", method = RequestMethod.POST)
	public ModelMap getDemob(@RequestParam String content) {
		ModelMap map = new ModelMap();
		map.addAttribute("result", new java.util.Date());
		return map;
	}
}