package com.example.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.example.dtos.ChatMessage;
import com.google.gson.Gson;

import io.lettuce.core.pubsub.RedisPubSubListener;

@Component
public class SubscriberHelper implements RedisPubSubListener<String, String> {

    private static final Logger logger = LoggerFactory.getLogger(SubscriberHelper.class);
   
    private SimpMessagingTemplate template;
    
    @Autowired
    public SubscriberHelper(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Override
    public void message(String channel, String message) {   
        logger.info("Subscribe message {} from channel {}", message, channel);     
        this.template.convertAndSend("/topic/public", new Gson().fromJson(message,ChatMessage.class));
    }

    @Override
    public void message(String pattern, String channel, String message) {
    }

    @Override
    public void subscribed(String channel, long count) {
    }

    @Override
    public void psubscribed(String pattern, long count) {
    }

    @Override
    public void unsubscribed(String channel, long count) {
    }

    @Override
    public void punsubscribed(String pattern, long count) {
    }

}
