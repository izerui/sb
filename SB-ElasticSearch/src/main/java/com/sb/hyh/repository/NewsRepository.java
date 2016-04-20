package com.sb.hyh.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.sb.hyh.entities.News;

public interface NewsRepository extends ElasticsearchRepository<News, String> {
    public List<News> findByContent(String content);
}
