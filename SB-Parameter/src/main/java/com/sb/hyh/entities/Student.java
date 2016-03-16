package com.sb.hyh.entities;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sb.hyh.status.StatusAttributeConverter;

@Entity
@Table(name = "student", catalog = "springboot")
public class Student implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Float sum;
	private Float avg;
	private Integer age;
	private String status;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sum", precision = 12, scale = 0)
	public Float getSum() {
		return this.sum;
	}

	public void setSum(Float sum) {
		this.sum = sum;
	}

	@Column(name = "avg", precision = 12, scale = 0)
	public Float getAvg() {
		return this.avg;
	}

	public void setAvg(Float avg) {
		this.avg = avg;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "status")
	@Convert(converter = StatusAttributeConverter.class)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
