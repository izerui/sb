package cn.conac.bpp.common.persistence.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import cn.conac.bpp.common.utils.IdGen;

/**
 * Entity支持类
 * 
 * @param <T>
 *            泛型对象
 */
@MappedSuperclass
public abstract class BaseEntity<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * @Override public String toString() { return
	 * ReflectionToStringBuilder.toString(this); }
	 */
}
