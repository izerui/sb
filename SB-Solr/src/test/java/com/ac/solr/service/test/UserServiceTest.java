package com.ac.solr.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sb.hyh.Application;
import com.sb.hyh.entities.User;
import com.sb.hyh.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserServiceTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAdd() {
        User user = new User();
        user.setId("1234");
        user.setName("1234");
        userRepository.save(user);
    }

    @Test
    public void testGetAll() {
        // 总数
        System.out.println(userRepository.count());
        // 总数遍历
        Iterable<User> iterable = userRepository.findAll();
        for (User user : iterable) {
            System.out.println(user);
        }
    }
}
