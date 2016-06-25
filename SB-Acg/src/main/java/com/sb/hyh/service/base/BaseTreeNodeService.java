package com.sb.hyh.service.base;

import com.sb.hyh.dao.base.search.DynamicSpecifications;
import com.sb.hyh.dao.base.search.Operator;
import com.sb.hyh.dao.base.search.SearchFilter;
import com.sb.hyh.vo.ITreeNode;
import com.sb.hyh.vo.TreeNode;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 通用树型ID实体服务
 */
public abstract class BaseTreeNodeService<T extends ITreeNode<T>, ID extends Serializable> extends BaseService<T, ID> {
    /**
     * 从根节点递归获取所有children
     * 数据量较大的实体请避免调用此函数,否则可能导致内存不足
     * 为避免循环引用,parent节点中children属性为空,children节点中parent属性为空
     */
    public List<TreeNode> getNodes() {
        return getNodes(Integer.MAX_VALUE);
    }

    /**
     * 从根节点指定层级递归获取children
     */
    public List<TreeNode> getNodes(int level) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();

        List<SearchFilter> filters = new ArrayList<SearchFilter>();
        filters.add(new SearchFilter("id", Operator.EQ, 1));
        Specification<T> spec = DynamicSpecifications.bySearchFilter(filters);
        List<T> list = baseDao.findAll(spec);

        for (int i = 0; i < list.size(); i++) {
            nodes.add(new TreeNode(list.get(i), level));
        }

        Collections.sort(nodes);
        return nodes;
    }

    /**
     * 根据ID递归所有
     */
    public List<TreeNode> getNodes(ID id) {
        return getNodes(id, Integer.MAX_VALUE);
    }

    /**
     * 根据ID获取子节点数组
     */
    public List<TreeNode> getChildren(ID id) {
        List<TreeNode> list = getNodes(id, 1);
        if (list.isEmpty()) {
            return new ArrayList<TreeNode>();
        } else {
            if (list.get(0).getChildren() != null) {
                Collections.sort(list.get(0).getChildren());
            }
            return list.get(0).getChildren();
        }
    }

    /**
     * 根据ID递归该ID指定层级的parent节点和children节点
     */
    public List<TreeNode> getNodes(ID id, int level) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();

        T treeNode = baseDao.findOne(id);
        if (treeNode == null) {
            return nodes;
        }

        nodes.add(new TreeNode(treeNode, level));
        Collections.sort(nodes);

        return nodes;
    }
}
