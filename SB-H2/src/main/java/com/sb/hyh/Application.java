package com.sb.hyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sb.hyh.entities.h2.Post;
import com.sb.hyh.repository.h2.PostRepository;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // 内存数据库操作
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        PostRepository postRepository = context.getBean(PostRepository.class);
        postRepository.save(new Post("title1", "content1"));
        postRepository.save(new Post("title2", "content2"));
        postRepository.save(new Post("title3", "content3"));
        postRepository.save(new Post("title4", "content4"));
        postRepository.save(new Post("title5", "content5"));
        System.out.println(postRepository.count());
    }
}