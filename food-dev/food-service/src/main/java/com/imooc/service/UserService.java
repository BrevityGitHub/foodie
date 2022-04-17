package com.imooc.service;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;

/**
 * @author mw
 * @version JDK 8
 * @interfaceName UserService
 * @date 2022/4/17 15:00
 */
public interface UserService {
	/**
	 * 判断用户是否存在
	 *
	 * @param username
	 * @return
	 */
	boolean queryUsernameIsExist(String username);

	/**
	 * 创建用户
	 *
	 * @param userBO
	 * @return
	 */
	Users createUser(UserBO userBO);
}
