package com.sb.hyh.web;

import com.sb.hyh.service.base.BaseTreeNodeService;
import com.sb.hyh.vo.ITreeNode;
import com.sb.hyh.vo.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.Collection;

/**
 * 通用树Controller
 */
public class GenericTreeNodeRestController<T extends ITreeNode<T>, ID extends Serializable> extends GenericRestController<T, ID> {
    @Autowired
    protected BaseTreeNodeService<T, ID> genericTreeNodeService;

    /**
     * 获取子节点数组
     */
    @ResponseBody
    @RequestMapping("getChildren")
    public Collection<TreeNode> getChildren(@RequestParam ID id) {
        return genericTreeNodeService.getChildren(id);
    }

    /**
     * 从顶级节点或指定ID节点迭代指定层数节点
     */
    @ResponseBody
    @RequestMapping("getNodes")
    public Collection<TreeNode> getNodes(ID id, @RequestParam(defaultValue = "0") int level) {
        if (id != null) {
            return genericTreeNodeService.getNodes(id, level);
        } else {
            return genericTreeNodeService.getNodes(level);
        }
    }
}
