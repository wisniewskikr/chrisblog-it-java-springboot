package com.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Flux;
import java.time.Duration;

@RestController
public class ChatMessageController {

    private List<String> messages = new ArrayList<String>();

    @PostConstruct
	public void init() {
        messages.add("Hi");
        messages.add("Hello World from Server-Sent Events (SSE)");        
        messages.add("These are authomatic messages sent by Server");
        messages.add("These messages are sent as stream");
        messages.add("SSE enables only communication from Server to Client");
        messages.add("Have a nice day");
        messages.add("Bye");
    }

    @GetMapping(value = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> sse() {

        AtomicInteger counter = new AtomicInteger(1);
        return Flux.fromStream(messages.stream())
                .map(line -> ServerSentEvent.<String> builder()
                        .id(String.valueOf(counter.getAndIncrement()))
                        .data(line)
                        .event("lineEvent")
                        .retry(Duration.ofMillis(1000))
                        .build())
                .delayElements(Duration.ofMillis(3000));

    }
    
}
