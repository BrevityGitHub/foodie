package com.imooc.pojo.vo;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;

import java.util.List;

/**
 * 商品详情VO
 */
public class ItemInfoVO {

	private Items item;

	private List<ItemsImg> itemsImgList;

	private List<ItemsSpec> itemSpecList;

	private ItemsParam itemParams;

	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}

	public List<ItemsImg> getItemsImgList() {
		return itemsImgList;
	}

	public void setItemsImgList(List<ItemsImg> itemsImgList) {
		this.itemsImgList = itemsImgList;
	}

	public List<ItemsSpec> getItemSpecList() {
		return itemSpecList;
	}

	public void setItemSpecList(List<ItemsSpec> itemSpecList) {
		this.itemSpecList = itemSpecList;
	}

	public ItemsParam getItemParams() {
		return itemParams;
	}

	public void setItemParams(ItemsParam itemParams) {
		this.itemParams = itemParams;
	}

	@Override
	public String toString() {
		return "ItemInfoVO{" +
				"item=" + item +
				", itemsImgList=" + itemsImgList +
				", itemSpecList=" + itemSpecList +
				", itemParams=" + itemParams +
				'}';
	}
}
