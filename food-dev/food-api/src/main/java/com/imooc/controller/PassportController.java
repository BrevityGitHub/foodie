package com.imooc.controller;

import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author mw
 * @version JDK 8
 * @className PassportController
 * @date 2022/4/17 15:11
 */
@RestController
@RequestMapping("passport")
public class PassportController {

	@Autowired
	private UserService userService;

	/**
	 * @param username
	 * @return
	 * @RequestParam：接收请求参数
	 */
	@GetMapping("/usernameIsExist")
	public HttpStatus usernameIsExist(@RequestParam String username) {
		// 判断用户名不为空
		if (StringUtils.isBlank(username)) {
			// 返回500
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		// 判断是否存在
		boolean isExist = userService.queryUsernameIsExist(username);
		if (isExist) {
			// 返回500
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		// 请求成功，用户名不重复，返回200
		return HttpStatus.OK;
	}

	/**
	 * @param userBO
	 * @return
	 * @RequestBody：接收json对象
	 */
	@PostMapping("/regist")
	public HttpStatus regist(@RequestBody UserBO userBO) {
		String username = userBO.getUsername();
		String password = userBO.getPassword();
		String confirmPassword = userBO.getConfirmPassword();
		// 1. 用户名和密码不能为空
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)
				|| StringUtils.isBlank(confirmPassword)) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		// 2. 用户名是否存在
		boolean isExist = userService.queryUsernameIsExist(username);
		if (isExist) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		// 3. 密码长度不能低于6位
		if (password.length() < 6) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		// 4. 两次密码是否一致
		if (!password.equals(confirmPassword)) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		// 5. 实现注册
		userService.createUser(userBO);
		return HttpStatus.OK;
	}
}
