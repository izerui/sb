package com.sb.hyh.vo;

import java.io.Serializable;
import java.util.List;

public class Catalog2 implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private List<Catalog2> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Catalog2> getList() {
        return list;
    }

    public void setList(List<Catalog2> list) {
        this.list = list;
    }
}
