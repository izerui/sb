package com.lottery.service;

import java.util.List;

import com.lottery.model.User;

public interface UserService {
	public User login(User user);

	public List<User> findAll();
}
