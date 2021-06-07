package com.ep.slackbot;

import com.ep.slackbot.config.AppProperties;
import com.ep.slackbot.model.WeatherDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootTest
public class RestTemplateTest {

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Gson gson;

    @Autowired
    private ModelMapper modelMapper;


    @Test
    void test() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);
        String resourceUrl = "http://api.openweathermap.org/data/2.5/weather?q=seoul&appid=" + appProperties.getWeather() + "&units=metric";

        ResponseEntity<Map> response = restTemplate.exchange(resourceUrl, HttpMethod.GET,entity,Map.class);

        LinkedHashMap<String,Object> map = (LinkedHashMap<String, Object>) response.getBody();
        System.out.println(map.get("weather"));

        LinkedHashMap<String, Object> main = (LinkedHashMap<String, Object>) map.get("main");

        ArrayList<LinkedHashMap<String, Object>> weather = (ArrayList<LinkedHashMap<String, Object>>) map.get("weather");
        System.out.println(weather);


    }

}
