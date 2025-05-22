package com.example.demoapp;

import com.example.demoapp.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WeatherController.class)
class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherService weatherService;

    @Test
    void getTemperatureReturnsValue() throws Exception {
        given(weatherService.getTemperature(10.0, 20.0)).willReturn(25.5);

        mockMvc.perform(get("/getTemperature").param("lat", "10.0").param("lon", "20.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("25.5"));
    }
}
