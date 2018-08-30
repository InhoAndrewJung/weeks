package com.weeks.util.payload;

import lombok.Data;

@Data
public class RegisterRequest {
	private String userEmail;
	private String userPassword;
	private String userName;

	public RegisterRequest() {

	}

	public RegisterRequest(String userEmail, String userPassword, String userName) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
	}

}
