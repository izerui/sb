package com.sb.hyh.vo;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
// 任何没有绑定到该类的属性都忽略
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    private String city;
    private String street;
}