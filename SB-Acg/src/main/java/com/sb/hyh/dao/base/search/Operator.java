package com.sb.hyh.dao.base.search;

public enum Operator {
    EQ, // field = value
    NEQ, // field <> value
    LIKE, // field like '%value%'
    LLIKE, // field like 'value%'
    RLIKE, // field like '%value'
    NLIKE, // field not like '%value%'
    NLLIKE, // field not like 'value%'
    NRLIKE, // field not like '%value'
    GT, // field > value
    LT, // field < value
    GTE, // field >= value
    LTE // field <= value
}