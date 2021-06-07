package com.ep.slackbot.service;

import com.ep.slackbot.config.AppProperties;
import com.ep.slackbot.entity.WeatherEntity;
import com.ep.slackbot.model.WeatherDto;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import net.gpedro.integrations.slack.SlackAttachment;
import net.gpedro.integrations.slack.SlackField;
import net.gpedro.integrations.slack.SlackMessage;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final SlackService slackService;
    private final Gson gson;
    private final AppProperties appProperties;

    public void dailyWeather() throws UnknownHostException {
        WeatherDto weatherDto = getCurrentWeather();

        String color = "#008000";


        SlackAttachment slackAttachment = new SlackAttachment();
        slackAttachment.setFallback("Current Weather!!");
        slackAttachment.setTitle("Current Weather Repory");

        SlackMessage slackMessage = new SlackMessage();
        slackMessage.setUsername("weather_bot");
        slackMessage.setIcon(":sunny:");
        slackMessage.setText("message");

        List<SlackField> fields = new ArrayList<>();
        SlackField message = new SlackField();
        message.setTitle("오늘날씨");
        message.setValue(weatherDto.toString());
        slackAttachment.setFields(Arrays.asList(message));

        slackMessage.setAttachments(Arrays.asList(slackAttachment));

        slackService.send(slackMessage);
    }

    private WeatherDto getCurrentWeather() throws UnknownHostException {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);
        String resourceUrl = "http://api.openweathermap.org/data/2.5/weather?q=seoul&appid=" + appProperties.getWeather() + "&units=metric";

        ResponseEntity<Map> response = restTemplate.exchange(resourceUrl, HttpMethod.GET,entity,Map.class);

        LinkedHashMap<String,Object> map = (LinkedHashMap<String, Object>) response.getBody();

        LinkedHashMap<String, Object> main = (LinkedHashMap<String, Object>) map.get("main");

        ArrayList<LinkedHashMap<String, Object>> weather = (ArrayList<LinkedHashMap<String, Object>>) map.get("weather");

        return WeatherDto.builder()
                .currentTime(ZonedDateTime.now())
                .ip(InetAddress.getLocalHost().getHostAddress())
                .temp(main.get("temp").toString())
                .feelsLike(main.get("feels_like").toString())
                .tempMax(main.get("temp_max").toString())
                .pressure(main.get("pressure").toString())
                .weather(weather.get(0).get("main").toString())
                .description(weather.get(0).get("description").toString())
                .build();
    }

}
