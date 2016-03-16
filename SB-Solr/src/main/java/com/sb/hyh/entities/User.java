package com.sb.hyh.entities;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Field("id")
	private String id;
	@Field("name")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
