package com.sb.hyh.entity;

import org.apache.solr.client.solrj.beans.Field;

public class User {
    @Field("id")
    private String id;
    @Field("name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
