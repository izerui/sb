package com.lottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lottery.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}