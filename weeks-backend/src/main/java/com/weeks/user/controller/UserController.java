package com.weeks.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weeks.user.service.UserService;
import com.weeks.user.vo.User;
import com.weeks.util.payload.APIResponse;
import com.weeks.util.payload.LoginRequest;
import com.weeks.util.payload.RegisterRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/user")
public class UserController {
	@Autowired
	UserService userService;
	
//	@GetMapping("/login")
//	public APIResponse (LoginRequest loginRequest) {
//		
//	}
	
	@Secured({"ROLE_USER"})
	@PostMapping("/currentUser")
	@CrossOrigin(origins="*", allowedHeaders="*")
	public User getCurrentUser(HttpSession session) {
		User currentUser = (User)session.getAttribute("currentUser");
		log.info(currentUser.toString());
		return currentUser;
	}

	@PostMapping("/register")
	public APIResponse register(RegisterRequest registerRequest) throws IOException {
		if (userService.existsByUserEmail(registerRequest.getUserEmail())) {// email 중복 처리.
			return new APIResponse(false, "email duplicated");
		}
		User user = new User(registerRequest);
		userService.register(user);

		log.info(user.toString());
		return new APIResponse(true, "registered successfully");
	}

	@PreAuthorize("hasAnyRole('ROLE_USER')")
	@GetMapping("/userList")
	public List<User> userList() {
		return userService.findAll();
	}
	
}