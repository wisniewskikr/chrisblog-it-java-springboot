package com.example.redis;

import io.lettuce.core.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    private static final Logger logger = LoggerFactory.getLogger(Publisher.class);
    
    RedisClient client;    

    public Publisher(){
        this.client = RedisClient.create("redis://localhost:6379");
    }

    public void publish(String channel, String message){
        logger.info("Publish message {} to channel {}", message, channel);
        var connection = this.client.connect();
        connection.sync().publish(channel,message);
    }

}
