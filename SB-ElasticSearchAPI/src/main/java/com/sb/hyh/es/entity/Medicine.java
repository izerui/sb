package com.sb.hyh.es.entity;

import java.util.Date;

public class Medicine {
    private Integer id;
    private String name;
    private String function;
    private Date date;

    public Medicine(Integer id, String name, String function, Date date) {
        this.id = id;
        this.name = name;
        this.function = function;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}