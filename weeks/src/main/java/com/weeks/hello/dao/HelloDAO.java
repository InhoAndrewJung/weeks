package com.weeks.hello.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weeks.hello.vo.Hello;

public interface HelloDAO extends JpaRepository<Hello, Integer>{
	
}
