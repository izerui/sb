package com.sb.hyh.status;

public enum StatusEnum {
	ENABLE(1, "启用"), DISABLE(-1, "禁用"), DELETED(-2, "已删除");

	private Integer value;
	private String description;

	StatusEnum(Integer value, String description) {
		this.value = value;
		this.description = description;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}