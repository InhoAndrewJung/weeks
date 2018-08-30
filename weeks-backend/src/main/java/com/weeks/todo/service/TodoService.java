package com.weeks.todo.service;

import java.util.Date;

import com.weeks.todo.vo.Todo;
import com.weeks.todo.vo.TodoRequest;
import com.weeks.todo.vo.TodoResponse;
import com.weeks.util.payload.APIResponse;

public interface TodoService {
	public APIResponse addTodo(Todo todo);
	public TodoResponse getAllTodos(Long userId, Date todoDate);
	public APIResponse updateTodo(TodoRequest todoRequest);
	public APIResponse deleteTodo(Integer todoId);
}
