package com.task.sberproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

public class WeatherResponse implements Serializable {
    @Getter @Setter
    private Integer temperature;

    @JsonProperty("main")
    public void setTemp(Map<String, Object> main) {
        // Может прийти Integer
        setTemperature((int)Math.round(Double.valueOf(String.valueOf(main.get("temp")))));
    }
}
