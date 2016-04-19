package com.sb.hyh.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

@Data
@Document(indexName = "hong", type = "book", shards = 1, replicas = 0)
public class Book {
    @Id
    private String id;
    private String title;
    @Field(type = FieldType.Nested)
    private List<Tag> tags;
}