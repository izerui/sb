package com.lottery.utils;

import org.apache.commons.beanutils.BeanUtilsBean;

/**
 * 简单封装Dozer, 实现深度转换Bean<->Bean的Mapper实现:
 */
public class BeanMapper {
	private static BeanUtilsBean notNull = new NullAwareBeanUtilsBean();

	/**
	 * 基于BeanUtils将对象A的值拷贝到对象B中. 忽略A的null值
	 */
	public static void copyIgnorNull(Object source, Object destinationObject) {
		try {
			notNull.copyProperties(destinationObject, source);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}