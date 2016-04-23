package com.sb.hyh.web;

import java.util.*;

import org.springframework.web.bind.annotation.*;

import com.sb.hyh.vo.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    /**
     * 查询所有
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    /**
     * 查询
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    /**
     * 增加
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "success";
    }

    /**
     * 更新
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}