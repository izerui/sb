package com.sb.hyh.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    /**
     * swagger:DEFAULT_INCLUDE_PATTERN = "/api/.*";
     */
    @RequestMapping("/api/test")
    public String login() {
        return "Hello World!";
    }

    /**
     * 忽略
     */
    @RequestMapping("/api")
    public String api() {
        return "Hello World!";
    }

    /**
     * 忽略
     */
    @RequestMapping("/test")
    public String test() {
        return "Hello World!";
    }
}
