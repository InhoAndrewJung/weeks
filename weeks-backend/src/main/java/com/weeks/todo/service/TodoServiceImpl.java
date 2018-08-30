package com.weeks.todo.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.weeks.todo.repository.TodoRepository;
import com.weeks.todo.vo.Todo;
import com.weeks.todo.vo.TodoResponse;
import com.weeks.util.payload.APIResponse;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	TodoRepository todoRepository;

	@Override
	public APIResponse addTodo(Todo todo) {
		if (todoRepository.saveAndFlush(todo) == null) {
			return new APIResponse(false, "fali to add todo");
		}
		return new APIResponse(true, "add todo" + todo.getTodoId() + " successfully");
	}

	@Override
	@Transactional
	public TodoResponse getAllTodos(Todo todo) {
		TodoResponse todoRespose = new TodoResponse();
		todoRespose.setCompletedTodos(todoRepository.findByTodoUidAndTodoDateLessThanEqualAndTodoStatus(todo.getTodoUid(), todo.getTodoDate(), true,
				new Sort(Sort.Direction.ASC, "todoId")));
		todoRespose.setUncompletedTodos(todoRepository.findByTodoUidAndTodoDateLessThanEqualAndTodoStatus(todo.getTodoUid(), todo.getTodoDate(),
				false, new Sort(Sort.Direction.ASC, "todoId")));
		return todoRespose;
	}

	@Override
	public APIResponse updateTodo(Todo todo) {
		if (todoRepository.updateTodo(todo) == 0) {
			return new APIResponse(false, "update " + todo.getTodoId() + " fail");
		}
		return new APIResponse(true, "update" + todo.getTodoId() + " success");
	}


	@Override
	public APIResponse deleteTodo(Todo todo) {
		todoRepository.deleteById(todo.getTodoId());
		return new APIResponse(true, "delete todo" + todo.getTodoId() + " successfully");
	}

}
