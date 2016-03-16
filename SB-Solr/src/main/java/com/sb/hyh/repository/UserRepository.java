package com.sb.hyh.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.sb.hyh.entities.User;

public interface UserRepository extends SolrCrudRepository<User, String> {

}