package com.weeks.todo.repository;

import java.util.Date;
import java.util.List;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.weeks.todo.vo.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	
	public List<Todo> findByTodoUidAndTodoDateLessThanEqualAndTodoStatus(
			@Param("todoUid") String todoUid,
			@Param("todoDate") Date todoDate, 
			@Param("todoStatus") Boolean todoStatus, Sort sort);
	
	@Transactional //update delete query
	@Modifying
	@Query("update Todo t set t.todoStatus = :#{#todo.todoStatus}, t.todoContent = :#{#todo.todoContent} where t.todoId = :#{#todo.todoId}")
	public int updateTodo(@Param("todo") Todo Todo);
	
}
