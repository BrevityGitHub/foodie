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
}
