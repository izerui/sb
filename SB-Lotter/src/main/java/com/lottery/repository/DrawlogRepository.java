package com.lottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lottery.model.Drawlog;

public interface DrawlogRepository extends JpaRepository<Drawlog, Integer> {

}