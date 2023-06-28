package com.example.redis;

import com.example.controllers.ChatController;
import com.example.dtos.ChatMessage;
import com.google.gson.Gson;

import io.lettuce.core.pubsub.RedisPubSubListener;

public class SubscriberHelper implements RedisPubSubListener<String, String> {

    private ChatController chatController;    

    public SubscriberHelper(ChatController chatController) {
        this.chatController = chatController;
    }

    @Override
    public void message(String channel, String message) {        
        chatController.sendMessage(new Gson().fromJson(message,ChatMessage.class));
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
