package com.sb.hyh.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class UUIDEntity implements Serializable {
    protected String id;

    @Id
    @GenericGenerator(name = "generator", strategy = "com.sb.hyh.dao.base.entity.strategy.UUIDGenerator")
    @GeneratedValue(generator = "generator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
