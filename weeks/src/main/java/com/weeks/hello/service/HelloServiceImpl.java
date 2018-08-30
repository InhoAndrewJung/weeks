package com.weeks.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weeks.hello.dao.HelloDAO;
import com.weeks.hello.vo.Hello;

@Service
public class HelloServiceImpl implements HelloService{
	@Autowired
	HelloDAO helloDAO;
	
	@Override
	public List<Hello> findAll() {
		return helloDAO.findAll();
	}

}
