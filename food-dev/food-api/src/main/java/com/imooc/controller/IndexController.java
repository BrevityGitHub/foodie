package com.imooc.controller;

import com.imooc.enums.YesOrNo;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.service.CarouselService;
import com.imooc.service.CategoryService;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author mw
 * @version JDK 8
 * @className IndexController
 * @date 2022/4/26 21:25
 */
@RestController
@RequestMapping("index")
@Api(value = "首页", tags = {"首页展示的相关接口"})
public class IndexController {

	@Autowired
	private CarouselService carouselService;
	@Autowired
	private CategoryService categoryService;

	/**
	 * 获取首页轮播图列表
	 *
	 * @return
	 */
	@GetMapping("/carousel")
	@ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
	public IMOOCJSONResult carousel() {
		List<Carousel> list = carouselService.queryAll(YesOrNo.YES.type);
		return IMOOCJSONResult.ok(list);
	}

	/**
	 * 首页分类展示需求：
	 * 1. 第一次刷新主页查询大分类，渲染展示到首页
	 * 2. 如果鼠标移到大分类，则加载其子分类的内容，如果已经存在子分类，则不需要加载(懒加载)
	 *
	 * @return
	 */
	@GetMapping("/cats")
	@ApiOperation(value = "获取商品一级分类", notes = "获取商品一级分类", httpMethod = "GET")
	public IMOOCJSONResult cats() {
		List<Category> list = categoryService.queryAllRootLevelCat();
		return IMOOCJSONResult.ok(list);
	}

	@GetMapping("/subCat/{rootCatId}")
	@ApiOperation(value = "获取商品子分类", notes = "获取商品子分类", httpMethod = "GET")
	public IMOOCJSONResult subCat(
			@ApiParam(name = "rootCatId", value = "一级分类id", required = true)
			@PathVariable Integer rootCatId) {
		if (rootCatId == null) {
			return IMOOCJSONResult.errorMsg("分类不存在！");
		}
		List<CategoryVO> list = categoryService.getSubCatList(rootCatId);
		return IMOOCJSONResult.ok(list);
	}
}
