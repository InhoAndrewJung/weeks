package com.weeks.user.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.weeks.util.payload.RegisterRequest;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@NotBlank
	@Email
	private String userEmail;

	@NotBlank
	private String userName;

	@NotBlank
	private String userPassword;

	private Date userDatetime;

	private String userAuthority;

	public User() {

	}

	public User(RegisterRequest registerRequest) {
		super();
		this.userEmail = registerRequest.getUserEmail();
		this.userName = registerRequest.getUserName();
		this.userPassword = registerRequest.getUserPassword();
	}
	
	public User(@NotBlank @Email String userEmail, @NotBlank String userName, @NotBlank String userPassword) {
		super();
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public User(User user) {
		this.userId = user.getUserId();
		this.userEmail = user.getUserEmail();
		this.userAuthority = user.getUserAuthority();
		this.userPassword = user.getUserPassword();
		this.userName = user.getUserName();
		this.userDatetime = user.getUserDatetime();
	}
	
	public User(int userId, @NotBlank @Email String userEmail, @NotBlank String userName, @NotBlank String userPassword,
			@NotBlank Date userDatetime, @NotBlank String userAuthority) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userDatetime = userDatetime;
		this.userAuthority = userAuthority;
	}
	

	@PrePersist
	public void preset() {
		this.userDatetime = new Date();
		this.userAuthority = "ROLE_USER"; 
	}

}