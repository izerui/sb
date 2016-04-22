package com.lottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lottery.model.Lotteryplay;

public interface LotteryplayRepository extends JpaRepository<Lotteryplay, Integer> {

}