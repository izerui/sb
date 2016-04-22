package com.lottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lottery.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByAccount(String account);

}