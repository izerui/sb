package com.sb.hyh.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sb.hyh.entities.Book;

@Service
public class BookServiceImpl implements BookServiceI {

	@Override
	@Cacheable(value = "books", key = "#isbn")
	public Book getByIsbn(String isbn) {
		System.out.println("getByIsbn");
		simulateSlowService();
		return new Book(isbn, "Book Title");
	}

	private void simulateSlowService() {
		try {
			long time = 5000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * 更新或创建
	 */
	@Override
	@CachePut(value = "books", key = "#isbn")
	public Book update(String isbn, Book book) {
		return new Book(book.getIsbn(), book.getTitle());
	}

	/**
	 * 删除
	 */
	@Override
	@CacheEvict(value = "books", key = "#isbn")
	public void evict(String isbn) {

	}
}