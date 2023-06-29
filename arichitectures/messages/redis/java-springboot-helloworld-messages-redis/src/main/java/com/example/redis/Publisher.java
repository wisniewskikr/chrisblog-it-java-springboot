package com.example.redis;

import io.lettuce.core.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    RedisClient client;

    private static final Logger logger = LoggerFactory.getLogger(Publisher.class);

    public Publisher(){
        this.client = RedisClient.create("redis://localhost:6379");
    }

    public void publish(String channel, String message){
        logger.info("Publish message {} on channel {}", message, channel);
        var connection = this.client.connect();
        connection.sync().publish(channel, message);
    }
}
