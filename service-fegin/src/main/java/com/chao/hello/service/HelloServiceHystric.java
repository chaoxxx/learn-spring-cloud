package com.chao.hello.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceHystric implements HelloService{

	@Override
	public String sayHello() {
		return "sorry ,server is busy !";
	}

}
