package com.weeks.user.service;

import java.util.List;

import com.weeks.user.vo.User;

public interface UserService {
	public List<User> findAll();

	public User register(User user);

	Boolean existsByUserEmail(String userEmail);

	Boolean existsByUserName(String userName);
}
