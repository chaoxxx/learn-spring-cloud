package com.chao.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
	@Autowired
	RestTemplate restTemplate;

	
	public String helloString(){
		return restTemplate.getForObject("http://EURAKE-HELLO/hello", String.class);
	}
}
