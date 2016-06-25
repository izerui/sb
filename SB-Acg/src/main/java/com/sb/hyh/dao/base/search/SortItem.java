package com.sb.hyh.dao.base.search;

/**
 * 排序
 */
public class SortItem {
    /**
     * 排序属性
     */
    private String field;
    /**
     * 排序规则,默认倒序
     */
    private String order = "desc";

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
