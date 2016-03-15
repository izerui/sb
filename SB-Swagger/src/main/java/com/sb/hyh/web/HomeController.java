package com.sb.hyh.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
