package com.task.sberproject.restcontroller;

import com.task.sberproject.entity.Weather;
import com.task.sberproject.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/ajax/weather/{cityName}")
    public ResponseEntity ajax(@PathVariable final String cityName) {
        log.info("***Trying to get weather for city: {}", cityName);
        try {
            Weather weather = weatherService.getWeather(cityName);
            return ResponseEntity.ok(weather);
        } catch (Exception e) {
            log.error("***Bad city in request: {}", e);
            return new ResponseEntity("{\"error\":\"bad request\"}", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Заглушка.
     * У SAP нет api для json User info
     * @return json аглушка
     */
    @GetMapping("/mock")
    public ResponseEntity mock() {
        log.info("***Send mock for user info");
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).
                body("{\"mock\":\"mock\"}");
    }
}
