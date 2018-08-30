package com.weeks.util.payload;

import lombok.Data;

@Data
public class LoginRequest {
	private String userEmail;
	private String userPassword;

	public LoginRequest() {

	}

	public LoginRequest(String userEmail, String userPassword) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

}
