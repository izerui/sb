//package com.xuebangsoft.core.webboot.repository.entity.strategy;
//
//import com.xuebangsoft.core.webboot.vo.ITreeNode;
//import org.apache.commons.lang3.StringUtils;
//import org.hibernate.HibernateException;
//import org.hibernate.cfg.ImprovedNamingStrategy;
//import org.hibernate.engine.spi.NamedSQLQueryDefinitionBuilder;
//import org.hibernate.engine.spi.SessionImplementor;
//import org.hibernate.id.IdentifierGenerator;
//
//import javax.persistence.Table;
//import java.io.Serializable;
//
///**
// * 树型ID策略
// */
//public class TreeIdGenerator implements IdentifierGenerator {
//
//    private static final int everyLevelIdLength = 2;
//
//    @Override
//    public Serializable generate(SessionImplementor sessionImplementor, Object o) throws HibernateException {
//        if (o instanceof ITreeNode) {
//            ITreeNode entity = (ITreeNode) o;
//            // 如果有传入ID则校验传入ID是否合法（顶层{everyLevelIdLength}位ID，下层ID需要以父节点ID开始且长度为父节点id + {everyLevelIdLength}）
//            if (StringUtils.isNotBlank(entity.getId())) {
//                if (entity.getParent() == null) {
//                    if (entity.getId().length() == everyLevelIdLength) {
//                        return entity.getId();
//                    } else {
//                        throw new HibernateException("使用树型ID策略的实体传入ID不合法（顶层ID必须为" + everyLevelIdLength + "位字符）：" + o.getClass().getName());
//                    }
//                } else {
//                    if (entity.getId().startsWith(entity.getParent().getId()) && entity.getId().length() == entity.getParent().getId().length() + everyLevelIdLength) {
//                        return entity.getId();
//                    } else {
//                        throw new HibernateException("使用树型ID策略的实体传入ID不合法：节点ID必须以父节点ID起始且长度=父节点ID长度+" + everyLevelIdLength);
//                    }
//                }
//            } else { // 未传入ID则自动生成ID
//                String tableName;
//                if (o.getClass().isAnnotationPresent(Table.class)) {
//                    tableName = o.getClass().getAnnotation(Table.class).name();
//                } else {
//                    tableName = new ImprovedNamingStrategy().classToTableName(o.getClass().getName());
//                }
//                StringBuffer newId = new StringBuffer();
//                NamedSQLQueryDefinitionBuilder builder = new NamedSQLQueryDefinitionBuilder();
//                if (entity.getParent() == null) { // 顶层节点
//                    builder.setQuery("select max(id) from " + o.getClass().getName());
//                } else { // 子节点
//                    if (StringUtils.isNotBlank(entity.getParent().getId())) {
//                        newId.append(entity.getParent().getId());
//                        builder.setQuery("select right(max(id)," + everyLevelIdLength + ") from " + tableName + " where length(id) = " + (entity.getParent().getId().length() + everyLevelIdLength) + " and parent = '" + entity.getParent().getId() + "'");
//                    } else {
//                        throw new HibernateException("使用树型ID策略的实体父节点ID为空：" + o.getClass().getName());
//                    }
//                }
//                // 获取最大值 + 1
//                Object result = sessionImplementor.createSQLQuery(builder.createNamedQueryDefinition()).uniqueResult();
//                int nextId = 0;
//                if (result == null) {
//                    nextId = 1;
//                } else {
//                    nextId = Integer.valueOf(result.toString()) + 1;
//                }
//                if (nextId < Math.pow(10, everyLevelIdLength)) {
//                    int newIdLength = String.valueOf(nextId).length();
//                    // ID空位补0
//                    for (int i = newIdLength; i < everyLevelIdLength; i++) {
//                        newId.append("0");
//                    }
//                    newId.append(nextId);
//                } else {
//                    throw new HibernateException("使用树型ID策略的下一位值已超过" + Math.pow(10, everyLevelIdLength));
//                }
//                return newId.toString();
//            }
//        } else {
//            throw new HibernateException("使用树型ID策略的实体非ITreeNode接口子类：" + o.getClass().getName());
//        }
//    }
//}
