package com.imooc.controller;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;
import com.imooc.pojo.vo.CommentLevelCountsVO;
import com.imooc.pojo.vo.ItemInfoVO;
import com.imooc.service.ItemService;
import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mw
 * @version JDK 8
 * @className IndexController
 * @date 2022/4/26 21:25
 */
@RestController
@RequestMapping("items")
@Api(value = "商品接口", tags = {"商品信息展示的相关接口"})
public class ItemsController extends BaseController {

	@Autowired
	private ItemService itemService;

	/**
	 * 查询商品详情
	 *
	 * @param itemId
	 * @return
	 */
	@GetMapping("/info/{itemId}")
	@ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
	public IMOOCJSONResult subCat(
			@ApiParam(name = "itemId", value = "商品Id", required = true)
			@PathVariable String itemId) {
		if (StringUtils.isBlank(itemId)) {
			return IMOOCJSONResult.errorMsg(null);
		}
		Items item = itemService.queryItemById(itemId);
		List<ItemsSpec> itemsSpecList = itemService.queryItemImgList(itemId);
		List<ItemsImg> itemsImgList = itemService.queryItemSpecList(itemId);
		ItemsParam itemsParam = itemService.queryItemParam(itemId);

		ItemInfoVO itemInfoVO = new ItemInfoVO();

		itemInfoVO.setItem(item);
		itemInfoVO.setItemsImgList(itemsImgList);
		itemInfoVO.setItemSpecList(itemsSpecList);
		itemInfoVO.setItemParams(itemsParam);

		return IMOOCJSONResult.ok(itemInfoVO);
	}

	/**
	 * 查询商品评价等级
	 *
	 * @param itemId
	 * @return
	 */
	@GetMapping("/commentLevel")
	@ApiOperation(value = "查询商品评价等级", notes = "查询商品评价等级", httpMethod = "GET")
	public IMOOCJSONResult commentLevel(
			@ApiParam(name = "itemId", value = "商品Id", required = true)
			@RequestParam String itemId) {
		if (StringUtils.isBlank(itemId)) {
			return IMOOCJSONResult.errorMsg(null);
		}
		CommentLevelCountsVO countsVO = itemService.queryCommentCounts(itemId);
		return IMOOCJSONResult.ok(countsVO);
	}

	/**
	 * 查询商品评论
	 *
	 * @param itemId
	 * @param level
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/comments")
	@ApiOperation(value = "查询商品评论", notes = "查询商品评论", httpMethod = "GET")
	public IMOOCJSONResult comments(
			@ApiParam(name = "itemId", value = "商品Id", required = true)
			@RequestParam String itemId,
			@ApiParam(name = "level", value = "评价等级")
			@RequestParam Integer level,
			@ApiParam(name = "page", value = "查询下一页的第几页")
			@RequestParam Integer page,
			@ApiParam(name = "pageSize", value = "分页的每一页显示的条数")
			@RequestParam Integer pageSize) {

		if (StringUtils.isBlank(itemId)) {
			return IMOOCJSONResult.errorMsg(null);
		}
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = COMMENT_PAGE_SIZE;
		}
		PagedGridResult grid = itemService.queryPagedComments(itemId, level, page, pageSize);

		return IMOOCJSONResult.ok(grid);
	}

	/**
	 * 搜索商品列表
	 *
	 * @param keywords
	 * @param sort
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/search")
	@ApiOperation(value = "搜索商品列表", notes = "搜索商品列表", httpMethod = "GET")
	public IMOOCJSONResult search(
			@ApiParam(name = "keywords", value = "关键字", required = true)
			@RequestParam String keywords,
			@ApiParam(name = "sort", value = "排序")
			@RequestParam String sort,
			@ApiParam(name = "page", value = "查询下一页的第几页")
			@RequestParam Integer page,
			@ApiParam(name = "pageSize", value = "分页的每一页显示的条数")
			@RequestParam Integer pageSize) {

		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = PAGE_SIZE;
		}
		PagedGridResult grid = itemService.searchItems(keywords, sort, page, pageSize);

		return IMOOCJSONResult.ok(grid);
	}

	/**
	 * 通过分类Id搜索商品列表
	 *
	 * @param cartId
	 * @param sort
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/catItems")
	@ApiOperation(value = "通过分类Id搜索商品列表", notes = "通过分类Id搜索商品列表", httpMethod = "GET")
	public IMOOCJSONResult catItems(
			@ApiParam(name = "cartId", value = "关键字", required = true)
			@RequestParam Integer cartId,
			@ApiParam(name = "sort", value = "排序")
			@RequestParam String sort,
			@ApiParam(name = "page", value = "查询下一页的第几页")
			@RequestParam Integer page,
			@ApiParam(name = "pageSize", value = "分页的每一页显示的条数")
			@RequestParam Integer pageSize) {

		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = PAGE_SIZE;
		}
		PagedGridResult grid = itemService.searchItemsByThirdCat(cartId, sort, page, pageSize);

		return IMOOCJSONResult.ok(grid);
	}
}
