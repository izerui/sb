package com.ac.springboot.entity;

import java.io.Serializable;

/**
 * 学生实体
 */
public class Student implements Serializable {
	private static final long serialVersionUID = 2120869894112984147L;
	private int id;
	private String name;
	private double sum;
	private double avg;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}