package com.sb.hyh.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sb.hyh.entities.News;

public interface NewsRepository extends ElasticsearchRepository<News, String> {
    public List<News> findByContent(String content);
}
