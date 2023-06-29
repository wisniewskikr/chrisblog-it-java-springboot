package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import io.lettuce.core.RedisClient;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;
import io.lettuce.core.pubsub.api.sync.RedisPubSubCommands;
import org.springframework.stereotype.Component;

@Component
public class Subscriber {
    
    private RedisPubSubCommands<String, String> sync;

    @Autowired
    public Subscriber(SubscriberHelper redisListner) {
        RedisClient client = RedisClient.create("redis://localhost:6379");
        StatefulRedisPubSubConnection<String, String> connection = client.connectPubSub();
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
