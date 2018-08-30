package com.weeks.todo.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TodoResponse {
	private List<Todo> completedTodos;
	private List<Todo> uncompletedTodos;

	public TodoResponse() {

	}
}
