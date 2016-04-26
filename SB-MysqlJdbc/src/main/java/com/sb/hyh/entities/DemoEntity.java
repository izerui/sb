package com.sb.hyh.entities;

/**
 * create table demo(id int primary key auto_increment,name varchar(50),intro varchar(1024)) DEFAULT CHARSET=utf8;
 */
public class DemoEntity {
	private int id;
	private String name;
	private String intro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
