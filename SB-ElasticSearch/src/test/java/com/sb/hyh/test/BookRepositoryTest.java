package com.sb.hyh.test;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sb.hyh.Application;
import com.sb.hyh.entities.Book;
import com.sb.hyh.entities.Tag;
import com.sb.hyh.repository.BookRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testSave() {
        Tag tag = new Tag();
        tag.setId("1");
        tag.setName("tech");

        Book book = new Book();
        book.setId("1");
        book.setTitle("Bigining with spring boot application and elasticsearch");
        book.setTags(Arrays.asList(tag));
        book.setName("elasticsearch入门大全");
        book.setPrice(110.5f);
        book.setAvailable(false);
        bookRepository.save(book);
    }

    // @Test
    // public void testFindByNameAndPrice() {
    // Pageable pageable = new PageRequest(0, 10);
    // Page<Book> page = bookRepository.findByNameAndPrice("入门", 110.5f,
    // pageable);
    // for (Book book : page) {
    // System.out.println(book.getId() + "," + book.getName());
    // }
    // }

    // @Test
    // public void testFindByNameOrPrice() {
    // Pageable pageable = new PageRequest(0, 10);
    // Page<Book> page = bookRepository.findByNameOrPrice("入门", 110.5f,
    // pageable);
    // for (Book book : page) {
    // System.out.println(book.getId() + "," + book.getName());
    // }
    // }

    // @Test
    // public void testFindByName() {
    // // Sort sort = new Sort(Direction.DESC, "");
    // Pageable pageable = new PageRequest(0, 10);
    // Page<Book> page = bookRepository.findByName("入门", pageable);
    // for (Book book : page) {
    // System.out.println(book.getId() + "," + book.getName());
    // }
    // }

    // @Test
    // public void testFindByNameNot() {
    // Pageable pageable = new PageRequest(0, 10);
    // Page<Book> page = bookRepository.findByNameNot("入门", pageable);
    // for (Book book : page) {
    // System.out.println(book.getId() + "," + book.getName());
    // }
    // }

    @Test
    public void testFindByAvailableTrue() {
        Pageable pageable = new PageRequest(0, 10);
        Page<Book> page = bookRepository.findByAvailableTrue(pageable);
        for (Book book : page) {
            System.out.println(book.getId() + "," + book.getName());
        }
    }
}
