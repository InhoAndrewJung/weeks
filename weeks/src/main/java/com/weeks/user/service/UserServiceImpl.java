package com.weeks.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weeks.user.dao.UserDAO;
import com.weeks.user.vo.User;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDAO;

	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}
}
