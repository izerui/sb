package com.sb.hyh.status;

import javax.persistence.AttributeConverter;

/**
 * 实体属性类型转换器。主要使用场景:1.持久化enum;2.加解密数据;3.持久化日期。
 * 
 * 转化实体属性,id属性和关系属性不可用
 */
public class StatusAttributeConverter implements AttributeConverter<String, Integer> {

	/**
	 * 将实体属性x转化为y存储到数据库中，即插入和更新操作时执行
	 */
	@Override
	public Integer convertToDatabaseColumn(String status) {
		try {
			return Integer.parseInt(status); // 如果是数字，则直接返回
		} catch (NumberFormatException e) {
			for (StatusEnum type : StatusEnum.values()) { // 如果不是数字，则通过StatusEnum来找到描述对应的数字
				if (status.equals(type.getDescription())) {
					return type.getValue();
				}
			}
		}
		throw new RuntimeException("Unknown StatusEnum: " + status); // 如果StatusEnum里不存在代表数字或描述，则抛出异常
	}

	/**
	 * 将数据库中的字段y转化为实体属性x，即查询操作时执行
	 */
	@Override
	public String convertToEntityAttribute(Integer value) {
		for (StatusEnum type : StatusEnum.values()) { // 将数字转换为描述
			if (value.equals(type.getValue())) {
				return type.getDescription();
			}
		}
		throw new RuntimeException("Unknown database value: " + value);
	}
}