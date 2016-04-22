package com.lottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lottery.model.Systeminfo;

public interface SysteminfoRepository extends JpaRepository<Systeminfo, Integer> {

}