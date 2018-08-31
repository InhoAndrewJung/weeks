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
	
	/**
	 * @param todo
	 * todoUid, todoDate
	 * 날짜 기준으로 같거나 이전의 todo중 완료되지 않은 것들 불러온다.
	 * @return
	 */
	@PostMapping("/getAllTodos")
	public TodoResponse getAllTodos(@RequestBody Todo todo) {
		return todoService.getAllTodos(todo);
	}
	
	/**
	 * @param todo
	 * todoId, todoContent, todoStatus
	 * checkbos event 와 content 수정 event를통합.
	 * @return
	 */
	@PostMapping("/updateTodo")
	public APIResponse updateTodo(@RequestBody Todo todo) { 
		return todoService.updateTodo(todo);
	} 
	
	/**
	 * @param todo
	 * todoId
	 * @return
	 */
	@PostMapping("/deleteTodo")
	public APIResponse deleteTodo(@RequestBody Todo todo) { 
		return todoService.deleteTodo(todo);
	}
	
}
