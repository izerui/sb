package com.sb.hyh.service;

import com.sb.hyh.entities.Book;

public interface BookService {
    public Book save(Book post);

    public Book findOne(String id);

    public Iterable<Book> findAll();
}