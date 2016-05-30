package com.sb.hyh.persistence.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@MappedSuperclass
public abstract class BaseEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String id;

	public BaseEntity() {
	}

	@PrePersist
	public void prePersist() {
		this.id = IdGen.uuid();
	}

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
