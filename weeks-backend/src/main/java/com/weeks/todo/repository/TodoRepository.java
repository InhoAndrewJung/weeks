package com.weeks.todo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.weeks.todo.vo.Todo;
import com.weeks.todo.vo.TodoRequest;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
	public List<Todo> findByUserIdAndTodoDateLessThanEqualAndTodoStatus(
			@Param("userId") Long userId, 
			@Param("todoDate") Date todoDate, 
			@Param("todoStatus") Boolean todoStatus, Sort sort);
	
	@Modifying
	@Query("update todo t set t.todo_status = :#{#todoRequest.todoStatus} t.todo_content = :#{#todoRequest.todoContent} where t.todo_id = :#{#todoRequest.todoId}")
	public int updateTodo(@Param("todo") TodoRequest todoRequest);
	
}
