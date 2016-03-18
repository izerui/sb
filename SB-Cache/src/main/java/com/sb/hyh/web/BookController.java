package com.sb.hyh.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sb.hyh.entities.Book;
import com.sb.hyh.service.BookServiceI;

@RestController
public class BookController {
	public static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookServiceI bookingService;

	@RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
	public Book get(@PathVariable String isbn) {
		long start = System.nanoTime();
		Book book = bookingService.getByIsbn(isbn);
		logger.info("execution time = {} ns", System.nanoTime() - start);
		return book;
	}
}
