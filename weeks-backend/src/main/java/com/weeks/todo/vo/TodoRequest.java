package com.weeks.todo.vo;

import lombok.Data;

@Data
public class TodoRequest {
	private Long todoId;
	private Boolean todoStatus;
	private String todoContent;

	public TodoRequest() {
		
	}
	
	public TodoRequest(Long todoId, Boolean todoStatus, String todoContent) {
		super();
		this.todoId = todoId;
		this.todoStatus = todoStatus;
		this.todoContent = todoContent;
	}

}
