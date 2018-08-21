package com.weeks.hello.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Hello {
	@Id
	@GeneratedValue
	private int id;

	@Column
	private String name;
	
}
