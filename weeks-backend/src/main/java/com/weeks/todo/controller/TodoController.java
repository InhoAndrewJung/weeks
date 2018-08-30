package com.weeks.todo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weeks.todo.vo.Todo;
import com.weeks.todo.vo.TodoRequest;
import com.weeks.util.payload.APIResponse;

@RestController
@RequestMapping(path="/todo")
public class TodoController {
	
	public APIResponse addTodo(TodoRequest request) {
		
		return new APIResponse();
	}
	
	public List<Todo> getAllTodos(HttpSession session, Date date) {
		//session에서 userId를 받아온다. 
		return null;
	}
	
	public APIResponse updateTodo(TodoRequest request) { //next 수정.
		return new APIResponse();
	}
	
	public APIResponse deleteTodo(int todoId) { //service : next 수정 필요.
		return new APIResponse();
	}
	
}
