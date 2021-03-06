package com.imooc.service;

import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.NewItemsVO;

import java.util.List;

/**
 * @author mw
 * @version JDK 8
 * @interfaceName CategoryService
 * @date 2022/4/27 20:16
 */
public interface CategoryService {
	/**
	 * 查询所有一级分类
	 *
	 * @return
	 */
	List<Category> queryAllRootLevelCat();

	/**
	 * 根据一级分类id查询子分类信息
	 *
	 * @param rootCatId
	 * @return
	 */
	List<CategoryVO> getSubCatList(Integer rootCatId);

	/**
	 * 查询首页每个一级分类下的6条最新商品数据
	 *
	 * @param rootCatId
	 * @return
	 */
	List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId);
}
