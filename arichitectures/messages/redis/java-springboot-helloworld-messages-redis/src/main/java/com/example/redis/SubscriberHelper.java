package com.example.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.lettuce.core.pubsub.RedisPubSubListener;

public class SubscriberHelper implements RedisPubSubListener<String, String> {

    private static final Logger logger = LoggerFactory.getLogger(SubscriberHelper.class);

    @Override
    public void message(String channel, String message) {
        logger.info("Subscribe message {} on channel {}", message, channel);
   
    }

    @Override
    public void message(String s, String k1, String s2) {

    }

    @Override
    public void subscribed(String s, long l) {

    }

    @Override
    public void psubscribed(String s, long l) {

    }

    @Override
    public void unsubscribed(String s, long l) {

    }

    @Override
    public void punsubscribed(String s, long l) {

    }

}
