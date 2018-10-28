package com.chao.hello.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chao.hello.service.HelloService;

@RestController
public class HelloControler {
	@Autowired
	HelloService helloService;
	
	@RequestMapping("/hello")
	public String sayHello(){
		return helloService.helloString();
	}
}
