package com.sb.hyh.entities;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

@Data
@Document(indexName = "hong", type = "news", shards = 10, replicas = 0, refreshInterval = "-1")
public class News {
    @Id
    private String id;
    private String link;
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd'T'HHmmss.SSS'Z'")
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time, index = FieldIndex.not_analyzed)
    @CreatedDate
    private Date createdDateTime;
}
