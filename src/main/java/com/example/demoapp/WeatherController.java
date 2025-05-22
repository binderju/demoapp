package com.example.demoapp;

import com.example.demoapp.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/getTemperature")
    public double getTemperature(@RequestParam double lat, @RequestParam double lon) {
        return weatherService.getTemperature(lat, lon);
    }
}
