package com.imooc.controller;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;
import com.imooc.pojo.vo.ItemInfoVO;
import com.imooc.service.ItemService;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("items")
@Api(value = "商品接口", tags = {"商品信息展示的相关接口"})
public class ItemsController {

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
}
