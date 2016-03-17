package com.sb.hyh.entities;

public class Student implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Float sum;
    private Float avg;
    private Integer age;
    private String status;

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

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    public Float getAvg() {
        return avg;
    }

    public void setAvg(Float avg) {
        this.avg = avg;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
