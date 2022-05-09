package com.imooc.service;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;
import com.imooc.pojo.vo.CommentLevelCountsVO;
import com.imooc.pojo.vo.ItemCommentVO;
import com.imooc.utils.PagedGridResult;

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

	/**
	 * 根据商品Id查询商品的评价等级数量
	 *
	 * @param itemId
	 */
	CommentLevelCountsVO queryCommentCounts(String itemId);

	/**
	 * 根据商品id查询商品评价，分页查询
	 *
	 * @param itemId
	 * @param level
	 * @param page
	 * @param pageSize
	 * @return
	 */
	PagedGridResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize);

	/**
	 * 搜索商品列表
	 *
	 * @param keywords
	 * @param sort
	 * @param page
	 * @param pageSize
	 * @return
	 */
	PagedGridResult searchItems(String keywords, String sort, Integer page, Integer pageSize);

	/**
	 * 根据分类ID搜索商品列表
	 *
	 * @param cartId
	 * @param sort
	 * @param page
	 * @param pageSize
	 * @return
	 */
	PagedGridResult searchItemsByThirdCat(Integer cartId, String sort, Integer page, Integer pageSize);
}
