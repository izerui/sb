package com.sb.hyh.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.sb.hyh.entities.Book;

public interface BookService {
	public Book save(Book post);

	public Book findOne(String id);

	public Iterable<Book> findAll();

	public Page<Book> findByTagsName(String name, PageRequest pageRequest);
}