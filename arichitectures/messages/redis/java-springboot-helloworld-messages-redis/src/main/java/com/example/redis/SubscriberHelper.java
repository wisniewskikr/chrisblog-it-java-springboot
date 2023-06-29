package com.example.redis;

import io.lettuce.core.pubsub.RedisPubSubListener;

public class SubscriberHelper implements RedisPubSubListener<String, String> {

    @Override
    public void message(String channel, String message) {
        System.out.println("Got the message on Redis. Channel: " + channel + "; Message: "+ message);
   
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
