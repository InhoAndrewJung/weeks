package com.weeks.user.vo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "user")
public class User {
	@Id
	private String uid;
}