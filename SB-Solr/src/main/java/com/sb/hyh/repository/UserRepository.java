package com.sb.hyh.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Boost;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.sb.hyh.entities.User;

public interface UserRepository extends SolrCrudRepository<User, String> {
	public Page<User> findByPopularity(Integer popularity, Pageable page);

	public Page<User> findByNameOrDescription(@Boost(2) String name, String description, Pageable page);

	@Highlight
	public HighlightPage<User> findByNameIn(Collection<String> name, Page<?> page);

	@Query(value = "name:?0")
	@Facet(fields = { "cat" }, limit = 20)
	public FacetPage<User> findByNameAndFacetOnCategory(String name, Pageable page);
}