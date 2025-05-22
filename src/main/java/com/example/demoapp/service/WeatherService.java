package com.example.demoapp.service;

import com.example.demoapp.model.TemperatureResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();

    public double getTemperature(double lat, double lon) {
        String url = "https://api.open-meteo.com/v1/forecast?latitude={lat}&longitude={lon}&current_weather=true";
        TemperatureResponse response = restTemplate.getForObject(url, TemperatureResponse.class, lat, lon);
        if (response != null && response.getCurrentWeather() != null) {
            return response.getCurrentWeather().getTemperature();
        }
        throw new IllegalStateException("No temperature data available");
    }
}
