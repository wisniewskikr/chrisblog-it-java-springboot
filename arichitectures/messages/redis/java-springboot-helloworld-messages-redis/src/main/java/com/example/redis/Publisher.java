package com.example.redis;

import io.lettuce.core.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    private static final Logger logger = LoggerFactory.getLogger(Publisher.class);
    
    private RedisClient client;    

    public Publisher(@Value("${redis.uri}") String redisUri){
        this.client = RedisClient.create(redisUri);
    }

    public void publish(String channel, String message){
        logger.info("***** Publish message {} on channel {} *****", message, channel);
        var connection = this.client.connect();
        connection.sync().publish(channel, message);
    }
}
