package com.sb.hyh.es.entity;

import java.util.LinkedList;
import java.util.List;

import com.sb.hyh.utils.es.FastJsonUtil;

public class MakeDataFactory {
	public static MakeDataFactory dataFactory = new MakeDataFactory();

	private MakeDataFactory() {

	}

	public MakeDataFactory getInstance() {
		return dataFactory;
	}

	public static List<String> getInitJsonData() {
		List<String> list = new LinkedList<String>();
		list.add(FastJsonUtil.getJson(new Medicine(1, "感冒 止咳糖浆", "功能主治：感冒止咳糖浆,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(2, "感冒灵颗粒", "功能主治：解热镇痛。头痛 ,清热。")));
		list.add(FastJsonUtil.getJson(new Medicine(3, "感冒 灵胶囊", "功能主治：银花感冒颗粒 ，头痛,清热，解表，利咽。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		list.add(FastJsonUtil.getJson(new Medicine(15, "仁和 感冒 颗粒", "功能主治：疏风清热，宣肺止咳,解表清热，止咳化痰。")));
		return list;
	}
}