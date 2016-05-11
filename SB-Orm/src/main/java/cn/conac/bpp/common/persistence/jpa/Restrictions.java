package cn.conac.bpp.common.persistence.jpa;

import java.util.Collection;

import org.hibernate.criterion.MatchMode;
import org.springframework.util.StringUtils;

import cn.conac.bpp.common.persistence.jpa.Criterion.Operator;

/**
 * 条件构造器 用于创建条件表达式
 * @author lee
 * @version 1.0
 */
public class Restrictions {

    /**
     * IS NULL
     * @param fieldName String
     * @return SimpleExpression
     */
    public static SimpleExpression isNull(String fieldName) {
        return new SimpleExpression(fieldName, null, Operator.ISNULL);
    }

    /**
     * IS NOT NULL
     * @param fieldName String
     * @return SimpleExpression
     */
    public static SimpleExpression isNotNull(String fieldName) {
        return new SimpleExpression(fieldName, null, Operator.ISNULL);
    }

    /**
     * 等于
     * @param fieldName String
     * @param value Object
     * @param ignoreNull boolean
     * @return SimpleExpression 
     */
    public static SimpleExpression eq(String fieldName, Object value, boolean... ignoreNull) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return new SimpleExpression(fieldName, value, Operator.EQ);
    }

    /**
     * 不等于
     * @param fieldName String
     * @param value Object
     * @param ignoreNull boolean
     * @return SimpleExpression
     */
    public static SimpleExpression ne(String fieldName, Object value, boolean... ignoreNull) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return new SimpleExpression(fieldName, value, Operator.NE);
    }

    /**
     * 模糊匹配 (前后模糊)
     * @param fieldName String
     * @param value  String
     * @param ignoreNull boolean
     * @return SimpleExpression
     */
    public static SimpleExpression like(String fieldName, String value, boolean... ignoreNull) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return new SimpleExpression(fieldName, value, Operator.LIKE);
    }

    /**
     * 模糊匹配 (后匹配)
     * @param fieldName String
     * @param value String
     * @param ignoreNull boolean 
     * @return SimpleExpression
     */
    public static SimpleExpression HLike(String fieldName, String value, boolean... ignoreNull) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return new SimpleExpression(fieldName, value, Operator.HLIKE);
    }

    /**
     * 模糊匹配 (前匹配)
     * @param fieldName String
     * @param value String
     * @param ignoreNull boolean
     * @return SimpleExpression
     */
    public static SimpleExpression QLike(String fieldName, String value, boolean... ignoreNull) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return new SimpleExpression(fieldName, value, Operator.QLIKE);
    }

    /**
     * 模糊匹配 
     * @param fieldName String
     * @param value String
     * @param matchMode MatchMode
     * @param ignoreNull boolean
     * @return SimpleExpression
     */
    public static SimpleExpression like(String fieldName, String value, MatchMode matchMode, boolean... ignoreNull) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return null;
    }

    /**
     * 大于
     * @param fieldName String
     * @param value Object
     * @param ignoreNull boolean
     * @return SimpleExpression
     */
    public static SimpleExpression gt(String fieldName, Object value, boolean... ignoreNull) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return new SimpleExpression(fieldName, value, Operator.GT);
    }

    /**
     * 小于
     * @param fieldName String
     * @param value Object
     * @param ignoreNull boolean
     * @return SimpleExpression
     */
    public static SimpleExpression lt(String fieldName, Object value, boolean... ignoreNull) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return new SimpleExpression(fieldName, value, Operator.LT);
    }

    /**
     * 小于等于
     * @param fieldName String
     * @param value Object
     * @param ignoreNull boolean
     * @return SimpleExpression
     */
    public static SimpleExpression lte(String fieldName, Object value, boolean... ignoreNull) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return new SimpleExpression(fieldName, value, Operator.LTE);
    }

    /**
     * 大于等于
     * @param fieldName String
     * @param value Object
     * @param ignoreNull boolean
     * @return SimpleExpression
     */
    public static SimpleExpression gte(String fieldName, Object value, boolean... ignoreNull) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return new SimpleExpression(fieldName, value, Operator.GTE);
    }

    /**
     * 并且
     * @param criterions LogicalExpression
     * @return LogicalExpression
     */
    public static LogicalExpression and(LogicalExpression... criterions) {
        return new LogicalExpression(criterions, Operator.AND);
    }

    /**
     * 或者
     * @param criterions Criterion
     * @return LogicalExpression
     */
    public static LogicalExpression or(Criterion... criterions) {
        return new LogicalExpression(criterions, Operator.OR);
    }

    /**
     * 包含于
     * @param fieldName String
     * @param value Collection
     * @param ignoreNull boolean
     * @return LogicalExpression
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