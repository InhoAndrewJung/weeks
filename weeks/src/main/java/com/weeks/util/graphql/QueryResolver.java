package com.weeks.util.graphql;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.weeks.hello.dao.HelloDAO;
import com.weeks.hello.vo.Hello;
import com.weeks.user.dao.UserDAO;
import com.weeks.user.vo.User;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {
	private HelloDAO helloDAO;
	private UserDAO userDAO;

    public List<Hello> getAllHellos() {
    	log.info("#######################helloResolver");
        return helloDAO.findAll();
    }
    
    public List<User> getAllUsers() {
    	log.info("#######################userResolver");
        return userDAO.findAll();
    }
}
