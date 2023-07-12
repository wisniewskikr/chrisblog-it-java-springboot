package com.example.configs;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicJmsConfig {
	
	private static final String API_QUEUE = "greeting-api";
	private static final String LISTENER_QUEUE = "greeting-listener";
	public static final String FANOUT = "fanout";
	
	@Bean
	public Declarables fanoutBindings() {
	    Queue fanoutQueue1 = new Queue(API_QUEUE, true);
	    Queue fanoutQueue2 = new Queue(LISTENER_QUEUE, true);
	    FanoutExchange fanoutExchange = new FanoutExchange(FANOUT);

	    return new Declarables(
	      fanoutQueue1,
	      fanoutQueue2,
	      fanoutExchange,
	      BindingBuilder.bind(fanoutQueue1).to(fanoutExchange),
	      BindingBuilder.bind(fanoutQueue2).to(fanoutExchange));
	}

}
