package com.sb.hyh.service;

import com.sb.hyh.entities.Book;

public interface BookServiceI {

	public Book getByIsbn(String isbn);

	public Book update(String isbn, Book book);

	public void evict(String isbn);
}