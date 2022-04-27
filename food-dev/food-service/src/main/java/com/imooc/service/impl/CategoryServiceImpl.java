package com.imooc.service.impl;

import com.imooc.mapper.CategoryMapper;
import com.imooc.mapper.CategoryMapperCustom;
import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author mw
 * @version JDK 8
 * @className CategoryServiceImpl
 * @date 2022/4/27 20:19
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private CategoryMapperCustom categoryMapperCustom;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Category> queryAllRootLevelCat() {
		Example example = new Example(Category.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("type", 1);
		List<Category> result = categoryMapper.selectByExample(example);
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<CategoryVO> getSubCatList(Integer rootCatId) {
		return categoryMapperCustom.getSubCatList(rootCatId);
	}
}
