package com.sb.hyh.persistence.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sb.hyh.persistence.entity.DataEntity;

/**
 * 继承自JpaRepository,带有基础的增删改查,分页
 * 
 * @param <T>
 *            带ID主键的model
 * @param <ID>
 *            泛型对象
 */
@NoRepositoryBean
public interface BaseDataRepository<T extends DataEntity<T>, ID extends Serializable>
		extends PagingAndSortingRepository<T, ID>, JpaSpecificationExecutor<T> {

	Page<T> findByCreateBy(String createBy, Pageable page);

	Page<T> findByUpdateBy(String updateBy, Pageable page);
}