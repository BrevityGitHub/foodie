package com.imooc.controller;

import com.imooc.enums.YesOrNo;
import com.imooc.pojo.Carousel;
import com.imooc.service.CarouselService;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
