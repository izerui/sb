package com.lottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lottery.model.Userlog;

public interface UserlogRepository extends JpaRepository<Userlog, Integer> {

}