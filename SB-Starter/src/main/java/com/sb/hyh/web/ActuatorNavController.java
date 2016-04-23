package com.sb.hyh.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * 新建controller，有两种配置方式：
 * 1、在configuration去用@Bean注解去new出来
 * 2、直接添加Controller注解的话，然后在这个configuration添加ComponentScan
 *    这种方式有个风险，就是package可能跟引用的工程包名重复，但也可能不是问题
 */
@Controller
@RequestMapping("${actuator.web.base:}")
public class ActuatorNavController {

    @RequestMapping(value="/actuator/list", method = RequestMethod.GET)
    @ResponseBody
    public String actuatorNavigate() throws IOException {
		return "hello";
	}
}
