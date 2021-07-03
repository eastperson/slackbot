package com.ep.slackbot.scheduler;

import com.ep.slackbot.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.UnknownHostException;

@Component
@RequiredArgsConstructor
@Slf4j
public class WeatherScheduler {

    private final WeatherService weatherService;

    @Scheduled(cron = "0 0 0/4 ? * MON-FRI", zone = "Asia/Seoul")
    public void weatherMessages() throws UnknownHostException {
        log.info("[TRY] send daily weather message");
        weatherService.dailyWeather();
    }

    @PostConstruct
    public void initMessage() throws UnknownHostException {
        log.info("[INIT] send daily weather message");
        weatherService.dailyWeather();
    }

}