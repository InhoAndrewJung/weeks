package com.weeks.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.weeks.user.repository.UserRepository;
import com.weeks.user.vo.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Boolean existsByUserEmail(String userEmail) {
		return userRepository.existsByUserEmail(userEmail);
	}

	@Override
	public Boolean existsByUserName(String userName) {
		return userRepository.existsByUserName(userName);
	}

	@Override
	public User register(User user) {
		user.setUserPassword(new BCryptPasswordEncoder().encode(user.getUserPassword()));
		userRepository.saveAndFlush(user);
		return user;
	}

}
