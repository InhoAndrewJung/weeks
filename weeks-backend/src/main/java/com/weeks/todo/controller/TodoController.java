package com.weeks.todo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weeks.todo.service.TodoService;
import com.weeks.todo.vo.Todo;
import com.weeks.todo.vo.TodoResponse;
import com.weeks.util.payload.APIResponse;

@RestController
@RequestMapping(path="/todo")
public class TodoController {
	@Autowired
	TodoService todoService;
	
	/**
	 * @param todo
	 * todoUid, todoContent, todoDate
	 * @return APIres
	 */
	@PostMapping("/addTodo")
	public APIResponse addTodo(@RequestBody Todo todo) {
		return todoService.addTodo(todo);
	}
	
	@PostMapping("/getAllTodos")
	public TodoResponse getAllTodos(@RequestBody Todo todo) {
		return todoService.getAllTodos(todo);
	}
	
	@PostMapping("/updateTodo")
	public APIResponse updateTodo(@RequestBody Todo todo) { 
		return todoService.updateTodo(todo);
	} 
	
	@PostMapping("/deleteTodo")
	public APIResponse deleteTodo(@RequestBody Todo todo) { 
		return todoService.deleteTodo(todo);
	}
	
}
