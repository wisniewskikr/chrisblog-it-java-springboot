package com.example.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;
import io.lettuce.core.pubsub.api.sync.RedisPubSubCommands;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Subscriber {

    private RedisPubSubCommands<String, String> sync;

    public Subscriber(@Value("${redis.uri}") String redisUri){
        RedisClient client = RedisClient.create(redisUri);
        StatefulRedisPubSubConnection<String, String> connection = client.connectPubSub();
        var redisListner = new SubscriberHelper();
        connection.addListener(redisListner);
        this.sync = connection.sync();
    }

    public void subscribe(String channel){
        this.sync.subscribe(channel);
    }

    public void  unsubscribe(String channel){
        this.sync.unsubscribe(channel);
    }

}
