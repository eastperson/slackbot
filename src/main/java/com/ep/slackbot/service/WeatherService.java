package com.ep.slackbot.service;

import com.ep.slackbot.entity.WeatherEntity;
import com.ep.slackbot.model.WeatherDto;
import lombok.RequiredArgsConstructor;
import net.gpedro.integrations.slack.SlackAttachment;
import net.gpedro.integrations.slack.SlackField;
import net.gpedro.integrations.slack.SlackMessage;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final SlackService slackService;

    public void dailyWeather() throws UnknownHostException {
        WeatherEntity currentWeatherEntity = getCurrentWeather();

        String color = "#008000";
        WeatherDto weatherDto =  WeatherDto.builder()
                .currentTime(ZonedDateTime.now())
                .ip(InetAddress.getLocalHost().getHostAddress())
                .build();


        SlackAttachment slackAttachment = new SlackAttachment();
        slackAttachment.setFallback("Current Weather!!");
        slackAttachment.setTitle("Current Weather Repory");

        SlackMessage slackMessage = new SlackMessage();
        slackMessage.setUsername("weather_bot");
        slackMessage.setIcon(":sunny:");

        List<SlackField> fields = new ArrayList<>();
        SlackField message = new SlackField();
        message.setTitle("오늘날씨");
        message.setValue(weatherDto.)



        slackService.send(slackMessage);
    }

    private WeatherEntity getCurrentWeather() {

        return null;
    }

}
