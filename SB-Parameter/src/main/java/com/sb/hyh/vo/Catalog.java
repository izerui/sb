package com.sb.hyh.vo;

public class Catalog {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Catalog [name=" + name + "]";
    }
}
