package com.lottery.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lottery.model.User;
import com.lottery.repository.UserRepository;
import com.lottery.service.UserService;
import com.lottery.utils.EncryptUtils;
import com.lottery.utils.ServiceException;

/**
 * 登录信息
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	/**
	 * 用户登录
	 */
	public User login(User user) {
		if (StringUtils.isBlank(user.getAccount())) {
			throw new ServiceException("用户名不能为空");
		}

		if (StringUtils.isBlank(user.getPassword())) {
			throw new ServiceException("密码不能为空");
		}

		User User = userRepository.findByAccount(user.getAccount());
		if (null == User) {
			throw new ServiceException("用户名不存在");
		}

		String password = EncryptUtils.encryptMD5(user.getPassword());
		if (!StringUtils.equals(password, User.getPassword())) {
			throw new ServiceException("密码输入错误");
		}
		return User;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}
}
