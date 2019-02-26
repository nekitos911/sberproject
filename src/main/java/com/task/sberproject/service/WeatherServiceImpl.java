package com.task.sberproject.service;

import com.task.sberproject.Constant;
import com.task.sberproject.entity.Weather;
import com.task.sberproject.utils.URIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final URIUtils uriUtils;

    @Value("${weather.appid}")
    private String appId;

    @Override
    public Weather getWeather(String cityName) {
        URI url = new UriTemplate(Constant.BASE_WEATHER_URL).expand(cityName, appId);
        return uriUtils.invoke(url, Weather.class);
    }
}
