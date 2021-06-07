package com.ep.slackbot;

import com.ep.slackbot.config.AppProperties;
import lombok.RequiredArgsConstructor;
import net.gpedro.integrations.slack.SlackApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SlackbotApplication {

    public static void main(String[] args) {

        SpringApplication.run(SlackbotApplication.class, args);

    }

}
