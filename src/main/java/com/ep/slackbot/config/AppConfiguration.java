package com.ep.slackbot.config;

import lombok.RequiredArgsConstructor;
import net.gpedro.integrations.slack.SlackApi;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
@RequiredArgsConstructor
public class AppConfiguration {

    private final AppProperties appProperties;

    @Bean
    public SlackApi slackApi(){
        return new SlackApi(appProperties.getSlackWeatherUrl());
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
