package com.weeks.todo.service;


import com.weeks.todo.vo.Todo;
import com.weeks.todo.vo.TodoResponse;
import com.weeks.util.payload.APIResponse;

/**
 * @author changheelee
 *
 */
public interface TodoService {
	
	/**
	 * @param todo
	 * @사용되는 멤버변수 : todoUid, todoContent, todoDate
	 * @return
	 */
	public APIResponse addTodo(Todo todo);
	public TodoResponse getAllTodos(Todo todo);
	public APIResponse updateTodo(Todo todo);
	public APIResponse deleteTodo(Todo todo);
}
