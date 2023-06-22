package com.ust.security.Model;

public class AuthenticationRequest {
	private String UserName;
	private String Password;
	
	public AuthenticationRequest() {
		// TODO Auto-generated constructor stub
	}

	public AuthenticationRequest(String userName, String password) {
		super();
		UserName = userName;
		Password = password;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	

}
