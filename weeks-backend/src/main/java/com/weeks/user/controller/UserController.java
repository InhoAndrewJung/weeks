
package com.weeks.user.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weeks.user.repository.UserRepository;
import com.weeks.user.vo.User;
import com.weeks.util.payload.APIResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/user")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@PostMapping("/userList")
	public List<User> userList() {
		return userRepository.findAll();
	}
	
	@PostMapping("/signManagement")
	public APIResponse signManagement(@RequestBody User user) {
		
		log.info("received uid : "+user.getUid());
		if (userRepository.existsByUid(user.getUid())) {
			log.info("이미 가입한 유저 : "+user.getUid());
			return new APIResponse(false, "already "+user.getUid()+"  exist");
		}
		userRepository.saveAndFlush(user);
		log.info("새로운 유저 : " + user.toString());
		return new APIResponse(true, "add user "+user.getUid()+" successfully");
	}
	
	@GetMapping("/signManagement")
	public APIResponse signManagementGet(User user) {
		
		log.info(user.getUid());
		if (userRepository.existsByUid(user.getUid())) {
			log.info("이미 가입한 유저 : "+user.getUid());
			return new APIResponse(false, "already exist");
		}
		userRepository.saveAndFlush(user);
		log.info("새로운 유저 : " + user.toString());
		return new APIResponse(true, "add user successfully");
	}
	
}