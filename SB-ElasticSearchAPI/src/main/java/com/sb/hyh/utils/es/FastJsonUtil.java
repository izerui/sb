package com.sb.hyh.utils.es;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class FastJsonUtil {
	// 生成json
	public static String getJson(Object obj) {
		return JSON.toJSONString(obj);
	}

	// 解析Object
	public static <T> T getObject(String json, Class<T> c) {
		T t = null;
		try {
			t = JSON.parseObject(json, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	// 解析List
	public static <T> List<T> getList(String json, Class<T> c) {
		List<T> list = new ArrayList<T>();
		try {
			list = JSON.parseArray(json, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 解析List
	public static List<String> getList(String json) {
		List<String> list = new ArrayList<String>();
		try {
			list = JSON.parseArray(json, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 解析List
	public static List<Map<String, Object>> listKeyMaps(String json) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = JSON.parseObject(json, new TypeReference<List<Map<String, Object>>>() {
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
