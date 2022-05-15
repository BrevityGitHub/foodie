package com.imooc.controller;

import com.imooc.pojo.bo.ShopcartBO;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mw
 * @version JDK 8
 * @className ShopCartController
 * @date 2022/5/4 14:11
 */
@RestController
@RequestMapping("shopcart")
@Api(value = "购物车接口controller", tags = {"购物车接口相关的api"})
public class ShopCartController {

	/**
	 * 添加商品到购物车
	 *
	 * @param userId
	 * @param shopcartBO
	 * @param request
	 * @param response
	 * @return
	 */
	@ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车", httpMethod = "POST")
	@PostMapping("/add")
	public IMOOCJSONResult add(@RequestParam String userId, @RequestBody ShopcartBO shopcartBO,
							   HttpServletRequest request, HttpServletResponse response) {

		if (StringUtils.isBlank(userId)) {
			IMOOCJSONResult.errorMsg("");
		}
		// TODO 前端用户在登录的情况下，添加商品到购物车，同时后端会同步到Redis中
		return IMOOCJSONResult.ok();
	}

	/**
	 * 从购物车删除商品
	 *
	 * @param userId
	 * @param itemSpecId
	 * @param request
	 * @param response
	 * @return
	 */
	@ApiOperation(value = "从购物车删除商品", notes = "从购物车删除商品", httpMethod = "POST")
	@PostMapping("/del")
	public IMOOCJSONResult del(@RequestParam String userId, @RequestParam String itemSpecId,
							   HttpServletRequest request, HttpServletResponse response) {

		if (StringUtils.isBlank(userId) || StringUtils.isBlank(itemSpecId)) {
			IMOOCJSONResult.errorMsg("参数不能为空！");
		}
		// TODO 用户在页面删除购物车中的商品数据，如果此时用户已经登录，则需要同步删除后端购物车中的数据
		return IMOOCJSONResult.ok();
	}
}
