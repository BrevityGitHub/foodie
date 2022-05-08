package com.imooc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.enums.CommentLevel;
import com.imooc.mapper.*;
import com.imooc.pojo.*;
import com.imooc.pojo.vo.CommentLevelCountsVO;
import com.imooc.pojo.vo.ItemCommentVO;
import com.imooc.pojo.vo.SearchItemsVO;
import com.imooc.service.ItemService;
import com.imooc.utils.DesensitizationUtil;
import com.imooc.utils.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mw
 * @version JDK 8
 * @className ItemServiceImpl
 * @date 2022/5/3 18:05
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsMapper;
	@Autowired
	private ItemsImgMapper itemsImgMapper;
	@Autowired
	private ItemsSpecMapper itemsSpecMapper;
	@Autowired
	private ItemsParamMapper itemsParamMapper;
	@Autowired
	private ItemsCommentsMapper itemsCommentsMapper;
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Items queryItemById(String itemId) {
		return itemsMapper.selectByPrimaryKey(itemId);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<ItemsImg> queryItemSpecList(String itemId) {
		Example itemsImgExp = new Example(ItemsImg.class);
		Example.Criteria criteria = itemsImgExp.createCriteria();
		criteria.andEqualTo("itemId", itemId);
		return itemsImgMapper.selectByExample(itemsImgExp);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<ItemsSpec> queryItemImgList(String itemId) {
		Example itemsSpecExp = new Example(ItemsSpec.class);
		Example.Criteria criteria = itemsSpecExp.createCriteria();
		criteria.andEqualTo("itemId", itemId);
		return itemsSpecMapper.selectByExample(itemsSpecExp);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public ItemsParam queryItemParam(String itemId) {
		Example itemsParamExp = new Example(ItemsParam.class);
		Example.Criteria criteria = itemsParamExp.createCriteria();
		criteria.andEqualTo("itemId", itemId);
		return itemsParamMapper.selectOneByExample(itemsParamExp);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public CommentLevelCountsVO queryCommentCounts(String itemId) {
		Integer goodCounts = getCommentCounts(itemId, CommentLevel.GOOD.type);
		Integer normalCounts = getCommentCounts(itemId, CommentLevel.NORMAL.type);
		Integer badCounts = getCommentCounts(itemId, CommentLevel.BAD.type);
		Integer totalCounts = goodCounts + normalCounts + badCounts;

		CommentLevelCountsVO countsVO = new CommentLevelCountsVO();
		countsVO.setTotalCounts(totalCounts);
		countsVO.setGoodCounts(goodCounts);
		countsVO.setNormalCounts(normalCounts);
		countsVO.setBadCounts(badCounts);
		return countsVO;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	Integer getCommentCounts(String itemId, Integer level) {
		ItemsComments condition = new ItemsComments();
		condition.setItemId(itemId);
		if (level != null) {
			condition.setCommentLevel(level);
		}
		return itemsCommentsMapper.selectCount(condition);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public PagedGridResult queryPagedComments(String itemId, Integer level,
											  Integer page, Integer pageSize) {
		Map<String, Object> map = new HashMap<>();
		map.put("itemId", itemId);
		map.put("level", level);
		// page：第几页; pageSize：每页显示条数
		PageHelper.startPage(page, pageSize);

		List<ItemCommentVO> list = itemsMapperCustom.queryItemComments(map);
		for (ItemCommentVO vo : list) {
			vo.setNickName(DesensitizationUtil.commonDisplay(vo.getNickName()));
		}
		return setterPagedGrid(list, page);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public PagedGridResult searchItems(String keywords, String sort,
									   Integer page, Integer pageSize) {
		Map<String, Object> map = new HashMap<>();
		map.put("keywords", keywords);
		map.put("sort", sort);
		// page：第几页; pageSize：每页显示条数
		PageHelper.startPage(page, pageSize);
		List<SearchItemsVO> list = itemsMapperCustom.searchItems(map);

		return setterPagedGrid(list, page);
	}

	private PagedGridResult setterPagedGrid(List<?> list, Integer page) {
		PageInfo<?> pageList = new PageInfo<>(list);
		PagedGridResult grid = new PagedGridResult();
		grid.setPage(page);
		grid.setRows(list);
		grid.setTotal(pageList.getPages());
		grid.setRecords(pageList.getTotal());
		return grid;
	}
}
