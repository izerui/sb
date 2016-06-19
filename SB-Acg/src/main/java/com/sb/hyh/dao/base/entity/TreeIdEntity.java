package com.sb.hyh.dao.base.entity;

import com.sb.hyh.vo.ITreeNode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * 树型实体
 */
@MappedSuperclass
public abstract class TreeIdEntity<T extends TreeIdEntity> implements Serializable, ITreeNode<T> {
    /**
     * 树型ID
     */
    protected String id;

    @Id
    @GenericGenerator(name = "generator", strategy = "com.xuebang.o2o.core.repository.entity.strategy.TreeIdGenerator")
    @GeneratedValue(generator = "generator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
