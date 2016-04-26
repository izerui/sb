package com.sb.hyh.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.hyh.entities.ROLE;
import com.sb.hyh.entities.User;
import com.sb.hyh.repository.UserRepository;

@Service
public class DataInit {
	@Autowired
	UserRepository userRepository;

	@PostConstruct
	public void dataInit() {
		User admin = new User();
		admin.setPassword("admin");
		admin.setUsername("admin");
		admin.setRole(ROLE.admin);
		userRepository.save(admin);

		User user = new User();
		user.setPassword("user");
		user.setUsername("user");
		user.setRole(ROLE.user);
		userRepository.save(user);
	}
}
