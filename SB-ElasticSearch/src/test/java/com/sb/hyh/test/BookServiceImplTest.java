package com.sb.hyh.test;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sb.hyh.Application;
import com.sb.hyh.entities.Book;
import com.sb.hyh.entities.Tag;
import com.sb.hyh.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class BookServiceImplTest {
    @Autowired
    private BookService bookService;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Before
    public void before() {
        elasticsearchTemplate.deleteIndex(Book.class);
        elasticsearchTemplate.createIndex(Book.class);
        elasticsearchTemplate.putMapping(Book.class);
        elasticsearchTemplate.refresh(Book.class, true);
    }

    /**
     * 相同覆盖
     */
    @Test
    public void testSave() throws Exception {
        Tag tag = new Tag();
        tag.setId("1");
        tag.setName("tech");
        Tag tag2 = new Tag();
        tag2.setId("2");
        tag2.setName("elasticsearch");

        Book book = new Book();
        book.setId("1");
        book.setTitle("Bigining with spring boot application and elasticsearch");
        book.setTags(Arrays.asList(tag, tag2));
        bookService.save(book);

        System.out.println(book.getId());

        Book book2 = new Book();
        book2.setId("1");
        book2.setTitle("Bigining with spring boot application");
        book2.setTags(Arrays.asList(tag, tag2));
        bookService.save(book2);

        System.out.println(book2.getId());
    }

    public void testFindOne() throws Exception {
    }

    public void testFindAll() throws Exception {
    }

    // @Test
    // public void testFindByTagsName() throws Exception {
    // Page<Book> books = bookService.findByTagsName("tech", new PageRequest(0,
    // 10));
    // Page<Book> books2 = bookService.findByTagsName("hong", new PageRequest(0,
    // 10));
    // Page<Book> books3 = bookService.findByTagsName("maz", new PageRequest(0,
    // 10));
    //
    // System.out.println(books.getTotalElements());
    // System.out.println(books2.getTotalElements());
    // System.out.println(books3.getTotalElements());
    // }
}
