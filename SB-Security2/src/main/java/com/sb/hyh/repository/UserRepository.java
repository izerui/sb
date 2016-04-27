package com.sb.hyh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.hyh.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
}
