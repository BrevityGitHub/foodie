package com.imooc.enums;

/**
 * @author mw
 * @version JDK 8
 * @enumName Sex
 * @date 2022/4/17 16:03
 */
public enum Sex {
	woman(0, "女"),
	man(1, "男"),
	secret(2, "保密");
	public final Integer type;
	public final String value;

	Sex(Integer type, String value) {
		this.type = type;
		this.value = value;
	}}
