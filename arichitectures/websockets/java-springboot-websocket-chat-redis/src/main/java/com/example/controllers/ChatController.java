package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.example.dtos.ChatMessage;
import com.example.redis.Publisher;
import com.google.gson.Gson;

@Controller
public class ChatController {

	@Value("${redis.channel}")
	private String channel;

	private Publisher publisher;

	@Autowired
	public ChatController(Publisher publisher) {
		this.publisher = publisher;
	}

	@MessageMapping("${websocket.receive.register}")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}

	@MessageMapping("${websocket.receive.message}")
	public void receiveMessage(@Payload ChatMessage chatMessage) {
		publisher.publish(channel, new Gson().toJson(chatMessage));
	}

	@SendTo("/topic/public")
	public ChatMessage sendMessage(ChatMessage chatMessage) {
		return chatMessage;
	}

}
