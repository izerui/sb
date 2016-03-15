package com.kong.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    /**
     * swagger:DEFAULT_INCLUDE_PATTERN = "/api/.*";
     */
    @RequestMapping("/api/test")
    @ResponseBody
    public String login() {
        return "Hello World!";
    }

    @RequestMapping("/api")
    @ResponseBody
    public String api() {
        return "Hello World!";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "Hello World!";
    }
}
