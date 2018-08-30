package com.weeks.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weeks.hello.service.HelloService;
import com.weeks.hello.vo.Hello;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloController {
	@Autowired
	HelloService helloService;

	@GetMapping("/welcome")
	public String welcome() {
		return "Hello guys!!!!";
	}

	@GetMapping("/helloList")
	public List<Hello> helloList() {
		List<Hello> list = helloService.findAll();
		log.info("hello this is helloController!");
		return list;
	}
}
