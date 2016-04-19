package com.sb.hyh.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sb.hyh.vo.HelloMessage;

/**
 * 表单提交
 */
@Controller
public class ValidController {

    /**
     * 表单路径
     */
    @RequestMapping(value = "/sayhello", method = RequestMethod.GET)
    public String sayHelloForm(Model model) {
        model.addAttribute("helloMessage", new HelloMessage());
        return "sayhello";
    }

    /**
     * 表单保存路径
     */
    @RequestMapping(value = "/sayhello", method = RequestMethod.POST)
    public String greetingSubmit(@Valid HelloMessage helloMessage, BindingResult bindingResult, Model model) {
        // 数据校验
        if (bindingResult.hasErrors()) {
            return "sayhello";
        }
        System.out.println(helloMessage.getName() + "," + helloMessage.getMessage());
        // 如果是ajax返回json情况,BindingResult生成对应的JSON数据
        System.out.println(bindingResult.toString());
        model.addAttribute("helloMessage", helloMessage);
        return "message";
    }
}
