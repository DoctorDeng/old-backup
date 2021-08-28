package com.doctor.entity;
/**
 * 用戶实体
 * @author Administrator
 *
 */
public class User {
	/**
	 * 用户ID
	 */
	private int userId;
	/**
	 * 用户账户名
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String password;
	
	
	public User() {
		super();
	}
	public User(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
