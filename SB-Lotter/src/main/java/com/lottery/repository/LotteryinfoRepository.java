package com.lottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lottery.model.Lotteryinfo;

public interface LotteryinfoRepository extends JpaRepository<Lotteryinfo, Integer> {

}