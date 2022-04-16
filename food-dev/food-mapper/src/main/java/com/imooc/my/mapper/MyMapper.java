package com.imooc.my.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author mw
 * @version JDK 8
 * @date 2022/4/15 19:10
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
