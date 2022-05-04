package com.imooc.pojo.vo;

/**
 * @author mw
 * @version JDK 8
 * @className CommentLevelCountsVO
 * @description 展示商品评价数
 * @date 2022/5/4 9:38
 */
public class CommentLevelCountsVO {

	public Integer totalCounts;

	public Integer goodCounts;

	public Integer normalCounts;

	public Integer badCounts;

	public Integer getTotalCounts() {
		return totalCounts;
	}

	public void setTotalCounts(Integer totalCounts) {
		this.totalCounts = totalCounts;
	}

	public Integer getGoodCounts() {
		return goodCounts;
	}

	public void setGoodCounts(Integer goodCounts) {
		this.goodCounts = goodCounts;
	}

	public Integer getNormalCounts() {
		return normalCounts;
	}

	public void setNormalCounts(Integer normalCounts) {
		this.normalCounts = normalCounts;
	}

	public Integer getBadCounts() {
		return badCounts;
	}

	public void setBadCounts(Integer badCounts) {
		this.badCounts = badCounts;
	}
}
