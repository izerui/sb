package com.sb.hyh.dao.base.entity;


import com.sb.hyh.vo.ITreeNode;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * 树型实体
 */
@MappedSuperclass
public abstract class TreeEntityWithoutIdStrategy<T extends TreeEntityWithoutIdStrategy> implements Serializable, ITreeNode<T> {
    /**
     * 树型ID
     */
    protected String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
