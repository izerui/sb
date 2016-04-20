package com.sb.hyh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.hyh.entities.Book;
import com.sb.hyh.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book Book) {
        bookRepository.save(Book);
        return Book;
    }

    @Override
    public Book findOne(String id) {
        return bookRepository.findOne(id);
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}