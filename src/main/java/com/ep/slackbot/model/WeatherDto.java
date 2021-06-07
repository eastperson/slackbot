package com.ep.slackbot.model;

import lombok.Builder;
import lombok.Data;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
@Builder
public class WeatherDto {

    private String ip;

    private ZonedDateTime currentTime;

    private String temp;

    private String feelsLike;

    private String tempMin;

    private String tempMax;

    private String pressure;

    private String weather;

    private String description;

}
