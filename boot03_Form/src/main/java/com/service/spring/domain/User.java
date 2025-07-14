package com.service.spring.domain;

public class User {
	private String userId;
	private String userName;
	private String password;
	private String userAddr;
	
	public User() {
	}
	
	public User(String userId, String userName, String password, String userAddr) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userAddr = userAddr;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userAddr=" + userAddr
				+ "]";
	}

	
	
}
