package com.lottery.config;

import com.lottery.utils.ConfigUtil;

/**
 * 从配置文件读取信息
 */
public class GlobalConfig {
	private static ConfigUtil configUtil = new ConfigUtil("config.properties", true);

	public static void main(String[] args) {
		System.out.println(configUtil.getValue("key"));
	}
}
