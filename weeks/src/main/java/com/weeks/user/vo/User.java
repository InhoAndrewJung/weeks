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
	@GeneratedValue
	private int userId;

	private String userEmail;
	private String userName;
	private String userPassword;
	private Date userDatetime;
	private String userAuthority;
}
