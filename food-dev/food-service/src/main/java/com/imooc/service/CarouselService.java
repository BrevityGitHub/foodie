package com.imooc.service;

import com.imooc.pojo.Carousel;

import java.util.List;

/**
 * @author mw
 * @version JDK 8
 * @interfaceName CarouselService
 * @date 2022/4/26 21:16
 */
public interface CarouselService {
	/**
	 * 查询所有轮播图接口
	 *
	 * @param isShow
	 */
	List<Carousel> queryAll(Integer isShow);

}
