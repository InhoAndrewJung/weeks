package com.weeks.user.vo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	private String userEmail;

	@GeneratedValue
	private int userId;
	
	private String userName;
	private String userPassword;
	private Date userDatetime;
	private String userAuthority;
}
