package com.sb.hyh.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sb.hyh.entities.News;
import com.sb.hyh.service.NewsService;

@RestController
@RequestMapping(value = "/api")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ResponseEntity<?> save() {
        News news = new News();
        news.setContent("中文");
        news.setCreatedDateTime(new Date());
        news.setLink("http://www.baidu.com");
        ResponseEntity<?> response = null;
        try {
            newsService.save(news);
            response = new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        ResponseEntity<?> response = null;
        try {
            Iterable<News> newslist = newsService.findAll();
            response = new ResponseEntity<Iterable>(newslist, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
