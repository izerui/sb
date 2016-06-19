package com.sb.hyh.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 树节点VO
 */
public class TreeNode implements ITreeNode<TreeNode>, Comparable<TreeNode> {
    /**
     * ID
     */
    private String id;
    /**
     * 节点名称
     */
    private String name;
    /**
     * 父节点
     */
    private TreeNode parent;
    /**
     * 子节点
     */
    private List<TreeNode> children;
    /**
     * 是否叶子节点(无子节点)
     */
    private boolean leaf = true;
    /**
     * 序号
     */
    private int sort;

    public TreeNode() {
    }

    /**
     * 构建时无限层递归构建父子节点
     */
    public TreeNode(ITreeNode entity) {
        init(entity, Integer.MAX_VALUE);
    }

    /**
     * 构建时按指定层数递归构建父子节点
     */
    public TreeNode(ITreeNode entity, int maxLevel) {
        init(entity, maxLevel);
    }

    private void init(ITreeNode node, int maxLevel) {
        this.id = node.getId();
        this.name = node.getName();
        this.sort = node.getSort();
        generateParent(this, node, maxLevel, 1);
        generateChildren(this, node, maxLevel, 1);
    }

    /**
     * 递归父节点
     */
    private void generateParent(TreeNode node, ITreeNode entity, int maxLevel, int currentLevel) {
        if (currentLevel > maxLevel) {
            return;
        }

        if (entity.getParent() != null) {
            TreeNode parentNode = new TreeNode();
            parentNode.id = entity.getParent().getId();
            parentNode.name = entity.getParent().getName();
            parentNode.sort = entity.getParent().getSort();

            node.setParent(parentNode);

            generateParent(parentNode, entity.getParent(), maxLevel, ++currentLevel);
        }
    }

    /**
     * 递归子节点
     */
    private void generateChildren(TreeNode node, ITreeNode entity, int maxLevel, int currentLevel) {
        if (entity.getChildren() != null && entity.getChildren().size() > 0) {
            node.setLeaf(false);
            if (currentLevel > maxLevel) {
                return;
            }

            node.children = new ArrayList<TreeNode>();
            for (ITreeNode childEntity : (Collection<ITreeNode>) entity.getChildren()) {
                TreeNode childNode = new TreeNode();
                childNode.id = childEntity.getId();
                childNode.name = childEntity.getName();
                childNode.sort = childEntity.getSort();
                node.children.add(childNode);
                Collections.sort(node.children);
                generateChildren(childNode, childEntity, maxLevel, ++currentLevel);
            }
        }
    }

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

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public int compareTo(TreeNode o) {
        return sort - o.sort;
    }
}
