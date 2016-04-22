package com.lottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lottery.model.Userbuylog;

public interface UserbuylogRepository extends JpaRepository<Userbuylog, Integer> {

}