package com.ep.slackbot;

import com.ep.slackbot.config.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SlackbotApplication {

    public static void main(String[] args) {

        SpringApplication.run(SlackbotApplication.class, args);

    }

}
