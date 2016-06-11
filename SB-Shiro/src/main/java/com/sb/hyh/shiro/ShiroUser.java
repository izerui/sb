package com.sb.hyh.shiro;

import java.io.Serializable;

/**
 * 自定义Authentication对象,使得Subject除了携带用户的登录名外还可以携带更多信息
 */
public class ShiroUser implements Serializable {
	private static final long serialVersionUID = -1373760761780840081L;
	public String id;
	public String number;
	public String name;

	public ShiroUser(String userid, String number, String name) {
		this.id = userid;
		this.number = number;
		this.name = name;
	}

	public ShiroUser(String number, String name) {
		this.number = number;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return name;
	}

	/**
	 * 作为默认的<shiro:principal/>输出
	 */
	@Override
	public String toString() {
		return number;
	}
}