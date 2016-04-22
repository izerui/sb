package com.lottery.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 读取配置文件工具类
 */
public class ConfigUtil {
	private InputStream in = null;
	private BufferedReader br = null;
	private Properties config = null;
	private String lineConfigTxt;

	public String getLineConfigTxt() {
		return lineConfigTxt;
	}

	public void setLineConfigTxt(String lineConfigTxt) {
		this.lineConfigTxt = lineConfigTxt;
	}

	public ConfigUtil(String configFilePath, boolean isConfig) {
		in = ConfigUtil.class.getClassLoader().getResourceAsStream(configFilePath);
		// in = new FileInputStream(new File(configFilePath));
		try {
			if (isConfig) {
				config = new Properties();
				config.load(in);
				// config.load(new InputStreamReader(in,
				// StaticValue.default_encoding));
				in.close();
			} else {
				// br = new BufferedReader(new InputStreamReader(in,
				// StaticValue.default_encoding));
				br = new BufferedReader(new InputStreamReader(in));
				this.lineConfigTxt = getTextLines();
			}
		} catch (IOException e) {
			System.out.println("加载配置文件时，出现问题!");
		}

	}

	public String getValue(String key) {
		try {
			return config.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String getTextLines() {
		StringBuilder sb = new StringBuilder();
		String temp = null;
		try {
			while ((temp = br.readLine()) != null) {
				temp = temp.trim();
				if (temp.length() > 0 && (!temp.startsWith("#"))) {
					sb.append(temp);
					sb.append("\n");
				}
			}
			br.close();
			in.close();
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("读取配置文件时，出现问题!");
		}
		return sb.toString();
	}
}
