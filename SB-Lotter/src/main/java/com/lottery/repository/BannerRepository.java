package com.lottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lottery.model.Article;
import com.lottery.model.Banner;

public interface BannerRepository extends JpaRepository<Banner, Integer> {

}