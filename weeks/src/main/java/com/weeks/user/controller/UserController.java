package com.weeks.user.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weeks.user.service.UserService;
import com.weeks.user.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/userList")
	public List<User> userList() {
		log.info("dddddd");
		return userService.findAll();
	}
	
}
