package com.weeks.util.graphql;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.weeks.hello.dao.HelloDAO;
import com.weeks.hello.vo.Hello;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class MutationResolver implements GraphQLMutationResolver {
	private HelloDAO helloDAO;

	public Hello createHello(String name) {
		log.info("param : " + name);
		Hello newHello = new Hello();
		newHello.setName(name);
		helloDAO.saveAndFlush(newHello);
		return newHello;
	}
}
