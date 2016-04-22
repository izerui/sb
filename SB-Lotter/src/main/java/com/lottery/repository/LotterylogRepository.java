package com.lottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lottery.model.Lotterylog;

public interface LotterylogRepository extends JpaRepository<Lotterylog, Integer> {

}