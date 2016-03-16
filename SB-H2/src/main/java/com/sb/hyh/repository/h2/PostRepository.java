package com.sb.hyh.repository.h2;

import org.springframework.data.repository.CrudRepository;

import com.sb.hyh.entities.h2.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

}
