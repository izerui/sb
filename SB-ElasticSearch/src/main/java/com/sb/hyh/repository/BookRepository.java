package com.sb.hyh.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.sb.hyh.entities.Book;

public interface BookRepository extends ElasticsearchRepository<Book, String> {

    Page<Book> findByTagsName(String name, Pageable pageable);
}