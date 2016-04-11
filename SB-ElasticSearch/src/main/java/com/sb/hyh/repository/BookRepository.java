package com.sb.hyh.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.sb.hyh.entities.Book;

public interface BookRepository extends ElasticsearchRepository<Book, String> {

    // {"bool" : {"must" : [ {"field" : {"name" : "?"}}, {"field" : {"price" :
    // "?"}} ]}}
    Page<Book> findByNameAndPrice(String name, float price, Pageable pageable);

    // {"bool" : {"should" : [ {"field" : {"name" : "?"}}, {"field" : {"price" :
    // "?"}} ]}}
    Page<Book> findByNameOrPrice(String name, float price, Pageable pageable);

    // {"bool" : {"must" : {"field" : {"name" : "?"}}}}
    Page<Book> findByName(String name, Pageable pageable);

    // {"bool" : {"must_not" : {"field" : {"name" : "?"}}}}
    Page<Book> findByNameNot(String name, Pageable pageable);

    // {"bool" : {"must" : {"range" : {"price" : {"from" : ?,"to" :
    // ?,"include_lower" : true,"include_upper" : true}}}}}
    Page<Book> findByPriceBetween(float from, float to, Pageable pageable);

    // {"bool" : {"must" : {"range" : {"price" : {"from" : null,"to" :
    // ?,"include_lower" : true,"include_upper" : true}}}}}
    Page<Book> findByPriceLessThan(float to, Pageable pageable);

    // {"bool" : {"must" : {"range" : {"price" : {"from" : ?,"to" :
    // null,"include_lower" : true,"include_upper" : true}}}}}
    Page<Book> findByPriceGreaterThan(float from, Pageable pageable);

    // {"bool" : {"must" : {"range" : {"price" : {"from" : null,"to" :
    // ?,"include_lower" : true,"include_upper" : true}}}}}
    Page<Book> findByPriceBefore(float to, Pageable pageable);

    // {"bool" : {"must" : {"range" : {"price" : {"from" : ?,"to" :
    // null,"include_lower" : true,"include_upper" : true}}}}}
    Page<Book> findByPriceAfter(float from, Pageable pageable);

    // {"bool" : {"must" : {"field" : {"name" : {"query" :
    // "?*","analyze_wildcard" : true}}}}}
    Page<Book> findByNameLike(float price, Pageable pageable);

    // {"bool" : {"must" : {"field" : {"name" : {"query" :
    // "?*","analyze_wildcard" : true}}}}}
    Page<Book> findByNameStartingWith(float price, Pageable pageable);

    // {"bool" : {"must" : {"field" : {"name" : {"query" :
    // "*?","analyze_wildcard" : true}}}}}
    Page<Book> findByNameEndingWith(String name, Pageable pageable);

    // {"bool" : {"must" : {"field" : {"name" : {"query" :
    // "*?*","analyze_wildcard" : true}}}}}
    Page<Book> findByNameContaining(String name, Pageable pageable);

    // {"bool" : {"must" : {"bool" : {"should" : [ {"field" : {"name" : "?"}},
    // {"field" : {"name" : "?"}} ]}}}}
    Page<Book> findByNameIn(Collection<String> names, Pageable pageable);;

    // {"bool" : {"must_not" : {"bool" : {"should" : {"field" : {"name" :
    // "?"}}}}}}
    Page<Book> findByNameNotIn(Collection<String> names, Pageable pageable);

    // {"bool" : {"must" : {"field" : {"available" : true}}}}
    Page<Book> findByAvailableTrue(Pageable pageable);

    // {"bool" : {"must" : {"field" : {"available" : false}}}}
    Page<Book> findByAvailableFalse(boolean available, Pageable pageable);

    // {"sort" : [{ "name" : {"order" : "desc"} }],"bool" : {"must" : {"field" :
    // {"available" : true}}}}
    Page<Book> findByAvailableTrueOrderByNameDesc(boolean available, String name, Pageable pageable);
}