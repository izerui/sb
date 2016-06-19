package cn.conac.test.controller;

import cn.conac.test.po.User;
import cn.conac.test.service.UserService;
import com.sb.hyh.web.GenericRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
@RequestMapping("user")
public class UserController extends GenericRestController<User, Long> {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/test")
    public String test() {
        System.out.println(userService);
        System.out.println(genericService);
        return "test";
    }
}
