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
 * @author changheelee todo
 */
@Data
@Entity
@Table(name = "todo")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long todoId;

	private Date todoDate;
	private Boolean todoStatus;
	private String todoContent;
	private String todoUid;

	@PrePersist
	public void preset() {
		this.todoStatus = false;
	}
}
