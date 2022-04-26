package com.imooc.service.impl;

import com.imooc.mapper.CarouselMapper;
import com.imooc.pojo.Carousel;
import com.imooc.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author mw
 * @version JDK 8
 * @className CarouselServiceImpl
 * @date 2022/4/26 21:17
 */
@Service
public class CarouselServiceImpl implements CarouselService {

	@Autowired
	private CarouselMapper carouselMapper;

	@Override
	public List<Carousel> queryAll(Integer isShow) {
		Example example = new Example(Carousel.class);
		example.orderBy("sort").desc();
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("isShow", isShow);
		List<Carousel> result = carouselMapper.selectByExample(example);
		return result;
	}
}
