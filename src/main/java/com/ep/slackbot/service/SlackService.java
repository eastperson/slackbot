package com.ep.slackbot.service;

import com.ep.slackbot.config.AppProperties;
import lombok.RequiredArgsConstructor;
import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SlackService {

    private final AppProperties appProperties;
    private final SlackApi slackApi;

    @Async
    public void send(String message) {
        try{
            slackApi.call(new SlackMessage(message));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Async
    public void send(SlackMessage slackMessage) {
        try{
            slackApi.call(slackMessage);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
