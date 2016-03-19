package com.hyh.es.entity;

public class Medicine {
	private Integer id;
	private String name;
	private String function;

	public Medicine() {
	}

	public Medicine(Integer id, String name, String function) {
		this.id = id;
		this.name = name;
		this.function = function;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", function=" + function + "]";
	}
}