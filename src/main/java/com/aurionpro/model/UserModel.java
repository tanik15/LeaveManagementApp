package com.aurionpro.model;

public class UserModel {
	private int userId;
	private String userName;
	private boolean isAdmin;
	private String userDept;
	private String password;
	private String email;


	public UserModel() {
	}


	public UserModel(int userId, String userName, boolean isAdmin, String userDept, String password,String email) {
		this.userId = userId;
		this.userName = userName;
		this.isAdmin = isAdmin;
		this.userDept = userDept;
		this.password = password;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUserDept() {
		return userDept;
	}

	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
