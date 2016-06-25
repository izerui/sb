package com.sb.hyh.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    public static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        System.out.println("index");
        return "index";
    }

    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public String index2() {
        System.out.println("index2");
        return "index2";
    }
}