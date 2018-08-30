package com.weeks.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.weeks.user.repository.UserRepository;
import com.weeks.user.vo.CustomUserDetails;
import com.weeks.user.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userDAO;

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException { //login을 위해email로 유저 정보를 가져온다.
		Optional<User> optionalUser = userDAO.findByUserEmail(userEmail);
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("username not found"));
		
		log.info("loadUserByUseraName : " + optionalUser.get().toString());
		
		return new CustomUserDetails(optionalUser.get());
	}
}
