package com.imooc.service.impl;

import com.imooc.enums.Sex;
import com.imooc.mapper.UsersMapper;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;
import com.imooc.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @author mw
 * @version JDK 8
 * @className UserServiceImpl
 * @date 2022/4/17 15:01
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UsersMapper usersMapper;

	private static final String USER_FACE = "d:/face.jpg";

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public boolean queryUsernameIsExist(String username) {
		Example userExample = new Example(Users.class);
		Example.Criteria userCriteria = userExample.createCriteria();
		userCriteria.andEqualTo("username", username);
		Users result = usersMapper.selectOneByExample(userExample);
		return result == null ? false : true;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Users createUser(UserBO userBO) {
		Users user = new Users();
		user.setUsername(userBO.getUsername());
		try {
			user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		user.setNickname(userBO.getUsername());
		user.setFace(USER_FACE);
		user.setBirthday(new Date());
		// 性别默认保密
		user.setSex(Sex.secret.type);
		usersMapper.insert(user);
		return user;
	}
}
