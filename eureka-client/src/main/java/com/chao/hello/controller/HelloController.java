package com.chao.hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${demo.word}")
	String systemName ;
	
	@Value("${server.port}")
	String port;
	
	@RequestMapping("/hello")
	public String sayHello(){
		String msg = systemName+" port: "+port+" say hello to you !";
		return msg;
	}

}
