package com.weeks.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weeks.user.vo.User;

public interface UserDAO extends JpaRepository<User, Integer>{

}
