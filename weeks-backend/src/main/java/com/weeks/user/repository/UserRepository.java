package com.weeks.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.weeks.user.vo.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Boolean existsByUid(String uid);
}
