package com.chao.weather.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chao.weather.service.WeatherService;

@RestController
public class WeatherControler {
	@Autowired
	WeatherService weatherService;
	
	
	@RequestMapping(value = "/getWeatherData/{id}")
	@ResponseBody
	public String getWeatherDate(@PathVariable String id){
		return weatherService.getWeatherData(id);
	}
	
}
