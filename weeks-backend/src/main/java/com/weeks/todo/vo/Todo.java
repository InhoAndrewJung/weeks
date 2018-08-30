package com.weeks.todo.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author changheelee
 * todo 
 */
@Data
@Entity
@Table(name="todo")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int todoId;

	private Date todoDate;
	private Boolean todoStatus;
	private String todoContent;
	
	private int userId;

	@PrePersist
	public void preset() {
		this.todoDate = new Date();
		this.todoStatus = false;
	}
}
