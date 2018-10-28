package com.chao.hello.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "EURAKE-HELLO",fallback = HelloServiceHystric.class)
public interface HelloService {
	@RequestMapping(value = "/hello" ,method = RequestMethod.GET)
	public String sayHello();
}
