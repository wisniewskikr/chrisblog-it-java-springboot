package com.example.listeners;

import java.util.UUID;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class IdListener {
    
    @EventListener(ApplicationReadyEvent.class)
    public void createId() {
		System.setProperty("id", UUID.randomUUID().toString());
	}

}