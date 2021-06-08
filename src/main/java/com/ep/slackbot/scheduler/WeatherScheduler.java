package com.ep.slackbot.scheduler;

import com.ep.slackbot.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

@Component
@RequiredArgsConstructor
public class WeatherScheduler {

    private final WeatherService weatherService;

    @Scheduled(cron = "0 0 0/4 ? * MON-FRI", zone = "Asia/Seoul")
    public void weatherMessages() throws UnknownHostException {
        weatherService.dailyWeather();
    }

}
