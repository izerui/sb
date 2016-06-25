package com.sb.hyh.persistence.persistence.jpa;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * 条件表达式
 */
public interface Criterion {
	enum Operator {
		// 等于
		EQ,
		// 不等于
		NE,
		// 模糊匹配 (前后模糊)
		LIKE,
		// 大于
		GT,
		// 小于
		LT,
		// 大于等于
		GTE,
		// 小于等于
		LTE,
		// 和
		AND,
		// 或
		OR,
		// 模糊匹配 (前匹配)
		QLIKE,
		// 模糊匹配 (后匹配)
		HLIKE, ISNULL, ISNOTNULL
	}

	Predicate toPredicate(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder builder);
}