package com.sb.hyh.persistence.persistence.jpa;

import java.util.Collection;

import org.hibernate.criterion.MatchMode;
import org.springframework.util.StringUtils;

import com.sb.hyh.persistence.persistence.jpa.Criterion.Operator;

/**
 * 条件构造器,用于创建条件表达式
 */
public class Restrictions {

	public static SimpleExpression isNull(String fieldName) {
		return new SimpleExpression(fieldName, null, Operator.ISNULL);
	}

	public static SimpleExpression isNotNull(String fieldName) {
		return new SimpleExpression(fieldName, null, Operator.ISNULL);
	}

	/**
	 * 等于
	 */
	public static SimpleExpression eq(String fieldName, Object value, boolean... ignoreNull) {
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		return new SimpleExpression(fieldName, value, Operator.EQ);
	}

	/**
	 * 不等于
	 */
	public static SimpleExpression ne(String fieldName, Object value, boolean... ignoreNull) {
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		return new SimpleExpression(fieldName, value, Operator.NE);
	}

	/**
	 * 模糊匹配(前后模糊)
	 */
	public static SimpleExpression like(String fieldName, String value, boolean... ignoreNull) {
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		return new SimpleExpression(fieldName, value, Operator.LIKE);
	}

	/**
	 * 模糊匹配(后匹配)
	 */
	public static SimpleExpression HLike(String fieldName, String value, boolean... ignoreNull) {
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		return new SimpleExpression(fieldName, value, Operator.HLIKE);
	}

	/**
	 * 模糊匹配(前匹配)
	 */
	public static SimpleExpression QLike(String fieldName, String value, boolean... ignoreNull) {
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		return new SimpleExpression(fieldName, value, Operator.QLIKE);
	}

	/**
	 * 模糊匹配
	 */
	public static SimpleExpression like(String fieldName, String value, MatchMode matchMode, boolean... ignoreNull) {
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		return null;
	}

	/**
	 * 大于
	 */
	public static SimpleExpression gt(String fieldName, Object value, boolean... ignoreNull) {
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		return new SimpleExpression(fieldName, value, Operator.GT);
	}

	/**
	 * 小于
	 */
	public static SimpleExpression lt(String fieldName, Object value, boolean... ignoreNull) {
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		return new SimpleExpression(fieldName, value, Operator.LT);
	}

	/**
	 * 小于等于
	 */
	public static SimpleExpression lte(String fieldName, Object value, boolean... ignoreNull) {
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		return new SimpleExpression(fieldName, value, Operator.LTE);
	}

	/**
	 * 大于等于
	 */
	public static SimpleExpression gte(String fieldName, Object value, boolean... ignoreNull) {
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		return new SimpleExpression(fieldName, value, Operator.GTE);
	}

	/**
	 * 并且
	 */
	public static LogicalExpression and(LogicalExpression... criterions) {
		return new LogicalExpression(criterions, Operator.AND);
	}

	/**
	 * 或者
	 */
	public static LogicalExpression or(Criterion... criterions) {
		return new LogicalExpression(criterions, Operator.OR);
	}

	/**
	 * 包含于
	 */
	@SuppressWarnings("rawtypes")
	public static LogicalExpression in(String fieldName, Collection value, boolean ignoreNull) {
		if (ignoreNull && (value == null || value.isEmpty())) {
			return null;
		}
		SimpleExpression[] ses = new SimpleExpression[value.size()];
		int i = 0;
		for (Object obj : value) {
			ses[i] = new SimpleExpression(fieldName, obj, Operator.EQ);
			i++;
		}
		return new LogicalExpression(ses, Operator.OR);
	}
}