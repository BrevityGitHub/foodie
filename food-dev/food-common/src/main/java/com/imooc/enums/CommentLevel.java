package com.imooc.enums;

/**
 * @author mw
 * @version JDK 8
 * @className CommentLevel
 * @description 商品评价等级的枚举
 * @date 2022/5/4 9:52
 */
public enum CommentLevel {
	GOOD(1, "好评"),
	NORMAL(2, "中评"),
	BAD(3, "差评");

	public final Integer type;
	public final String value;

	CommentLevel(Integer type, String value) {
		this.type = type;
		this.value = value;
	}
}
