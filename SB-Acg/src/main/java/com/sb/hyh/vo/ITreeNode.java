package com.sb.hyh.vo;

import java.util.List;

/**
 * 树节点接口
 */
public interface ITreeNode<T extends ITreeNode> {

    /**
     * 获取节点ID
     */
    String getId();

    /**
     * 获取节点名称
     */
    String getName();

    /**
     * 获取父节点
     */
    T getParent();

    /**
     * 获取子节点
     */
    List<T> getChildren();

    /**
     * 获取排序序号
     */
    int getSort();
}
