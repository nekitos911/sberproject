package com.task.sberproject;

public interface Constant {
    String UNITS_FORMAT = "metric";
    String BASE_WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q={cityName}&units="
            + UNITS_FORMAT + "&appid={appid}";
}
