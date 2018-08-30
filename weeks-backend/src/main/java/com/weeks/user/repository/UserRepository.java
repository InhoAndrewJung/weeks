package com.weeks.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weeks.user.vo.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserEmail(String userEmail);

	Boolean existsByUserName(String userName);

	Boolean existsByUserEmail(String userEmail);
}
