package com.weeks.util.payload;

import lombok.Data;

@Data
public class APIResponse {
	private Boolean success;
	private String message;

	public APIResponse() {

	}

	public APIResponse(Boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	
}
