package com.lottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lottery.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}