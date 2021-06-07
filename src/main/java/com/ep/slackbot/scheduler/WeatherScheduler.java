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

    @Scheduled(cron = "0 0 5 * * *", zone = "Asia/Seoul")
    public void weatherMessages() throws UnknownHostException {
        System.out.println("send message");
        weatherService.dailyWeather();
    }

}
