package com.ep.slackbot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("app")
public class AppProperties {

    private String weather;

    @Value("${slack.weather.url}")
    private String slackWeatherUrl;

}
