package com.imooc.pojo.vo;

import java.util.Date;

/**
 * @author mw
 * @version JDK 8
 * @className ItemCommentVO
 * @description 用于展示商品评价的VO
 * @date 2022/5/4 10:38
 */
public class ItemCommentVO {
	private Integer commentLevel;

	private String content;

	private String specName;

	private Date createdTime;

	private String userFace;

	private String nickName;

	public Integer getCommentLevel() {
		return commentLevel;
	}

	public void setCommentLevel(Integer commentLevel) {
		this.commentLevel = commentLevel;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getUserFace() {
		return userFace;
	}

	public void setUserFace(String userFace) {
		this.userFace = userFace;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "ItemCommentVO{" +
				"commentLevel=" + commentLevel +
				", content='" + content + '\'' +
				", specName='" + specName + '\'' +
				", createdTime=" + createdTime +
				", userFace='" + userFace + '\'' +
				", nickName='" + nickName + '\'' +
				'}';
	}
}
