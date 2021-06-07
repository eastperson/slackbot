package com.ep.slackbot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("app")
public class AppProperties {

    @Value("${app.weatherEntity.key}")
    private String weather;

    @Value("${slack.weatherEntity.url}")
    private String slackWeatherUrl;

}
