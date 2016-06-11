package com.sb.hyh.persistence.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * 不是JPA管理的Repository,用于定制Repository
 */
@NoRepositoryBean
public interface MyBaseRepository<T, ID extends Serializable> extends Repository<T, ID> {

	T findOne(ID id);

	T save(T entity);
}