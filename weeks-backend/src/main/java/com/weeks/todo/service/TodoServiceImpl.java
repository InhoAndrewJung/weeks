package com.weeks.todo.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.weeks.todo.repository.TodoRepository;
import com.weeks.todo.vo.Todo;
import com.weeks.todo.vo.TodoRequest;
import com.weeks.todo.vo.TodoResponse;
import com.weeks.util.payload.APIResponse;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	TodoRepository todoRepository;

	
	
	@Override
	@Transactional
	public TodoResponse getAllTodos(Long userId, Date todoDate) {
		TodoResponse todoRespose = new TodoResponse();
		todoRespose.setCompletedTodos(todoRepository.findByUserIdAndTodoDateLessThanEqualAndTodoStatus(userId, todoDate,
				true, new Sort(Sort.Direction.ASC, "todoId")));
		todoRespose.setUncompletedTodos(todoRepository.findByUserIdAndTodoDateLessThanEqualAndTodoStatus(userId,
				todoDate, false, new Sort(Sort.Direction.ASC, "todoId")));
		return todoRespose;
	}

	@Override
	public APIResponse updateTodo(TodoRequest todoRequest) {
		if (todoRepository.updateTodo(todoRequest) == 0) {
			return new APIResponse(false, "update fail");
		}
		return new APIResponse(true, "update"+todoRequest.getTodoId()+" success");
	}

	@Override
	public APIResponse addTodo(Todo todo) {
		if (todoRepository.saveAndFlush(todo) == null) {
			return new APIResponse(false, "fali to add todo");
		}
		return new APIResponse(true, "add todo"+todo.getTodoId()+" successfully");
	}

	@Override
	public APIResponse deleteTodo(Integer todoId) {
		todoRepository.deleteById(todoId);
		return new APIResponse(true, "delete todo"+todoId+" successfully");
	}

}
