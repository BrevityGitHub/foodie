package com.imooc.pojo.bo;

/**
 * @author mw
 * @version JDK 8
 * @className UserBO
 * @date 2022/4/17 15:45
 */
public class UserBO {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	private String confirmPassword;
}
