package com.example.redis;

// import com.anubhav.websockets.WebSocketSessionManager;
// import io.lettuce.core.pubsub.RedisPubSubListener;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.web.socket.TextMessage;

import java.io.IOException;

import io.lettuce.core.pubsub.RedisPubSubListener;

public class SubscriberHelper implements RedisPubSubListener<String, String> {

    @Override
    public void message(String channel, String message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'message'");
    }

    @Override
    public void message(String pattern, String channel, String message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'message'");
    }

    @Override
    public void subscribed(String channel, long count) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subscribed'");
    }

    @Override
    public void psubscribed(String pattern, long count) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'psubscribed'");
    }

    @Override
    public void unsubscribed(String channel, long count) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unsubscribed'");
    }

    @Override
    public void punsubscribed(String pattern, long count) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'punsubscribed'");
    }
    // private WebSocketSessionManager webSocketSessionManager;

    // private static final Logger logger = LoggerFactory.getLogger(SubscriberHelper.class);

    // public SubscriberHelper(WebSocketSessionManager webSocketSessionManager){
    //     this.webSocketSessionManager = webSocketSessionManager;
    // }
    // @Override
    // public void message(String channel, String message) {
    //     logger.info("got the message on redis "+ channel+ " and "+ message);
    //     var ws = this.webSocketSessionManager.getWebSocketSessions(channel);
    //     try {
    //         ws.sendMessage(new TextMessage(message));
    //     } catch (IOException e) {
    //         throw new RuntimeException(e);
    //     }
    // }

    // @Override
    // public void message(String s, String k1, String s2) {

    // }

    // @Override
    // public void subscribed(String s, long l) {

    // }

    // @Override
    // public void psubscribed(String s, long l) {

    // }

    // @Override
    // public void unsubscribed(String s, long l) {

    // }

    // @Override
    // public void punsubscribed(String s, long l) {

    // }
}
