package com.imooc.service;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;

import java.util.List;

/**
 * @author mw
 * @version JDK 8
 * @interfaceName ItemService
 * @date 2022/5/3 18:05
 */
public interface ItemService {
	/**
	 * 根据商品Id查询详情
	 *
	 * @param itemId
	 * @return
	 */
	Items queryItemById(String itemId);

	/**
	 * 根据商品Id查询商品图片列表
	 *
	 * @param itemId
	 * @return
	 */
	List<ItemsImg> queryItemSpecList(String itemId);

	/**
	 * 根据商品Id查询商品规格
	 *
	 * @param itemId
	 * @return
	 */
	List<ItemsSpec> queryItemImgList(String itemId);

	/**
	 * 根据商品Id查询商品属性
	 *
	 * @param itemId
	 * @return
	 */
	ItemsParam queryItemParam(String itemId);
}
