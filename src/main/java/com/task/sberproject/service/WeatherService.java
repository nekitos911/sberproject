package com.task.sberproject.service;

import com.task.sberproject.entity.Weather;

public interface WeatherService {
    Weather getWeather(String cityName);
}
