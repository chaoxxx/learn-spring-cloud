package com.chao.weather.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.chao.util.http.HttpUtil;

@Service
public class WeatherService {

	@Value("${weather.http.url}")
	String weatherUrl;

	public String getWeatherData(String cityId) {
		Map<String, String> param = new HashMap<>();
		param.put("cityId",cityId);
		return HttpUtil.getForRest(cityId, weatherUrl);
	}
}
