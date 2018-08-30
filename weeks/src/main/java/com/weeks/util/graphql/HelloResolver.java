package com.weeks.util.graphql;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.weeks.hello.dao.HelloDAO;
import com.weeks.hello.vo.Hello;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
@AllArgsConstructor
public class HelloResolver implements GraphQLResolver<Hello> {
	private HelloDAO helloDAO;

    public List<Hello> getAllHellos() {
    	log.info("#######################helloResolver");
        return helloDAO.findAll();
    }
}
