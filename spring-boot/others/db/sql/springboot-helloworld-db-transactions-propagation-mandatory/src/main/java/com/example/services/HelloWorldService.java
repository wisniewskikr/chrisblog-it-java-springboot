package com.example.services;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
	
	private static final Long HELLO_ENTITY_ID = Long.valueOf(1);
	private static final Long WORLD_ENTITY_ID = Long.valueOf(1);
	private static final Long ERROR_TRANSACTION_HELLO_ENTITY_ID = Long.valueOf(2);
	private static final Long ERROR_TRANSACTION_WORLD_ENTITY_ID = Long.valueOf(2);

	private HelloService helloService;
	private WorldService worldService;
	
	public HelloWorldService(HelloService helloService, WorldService worldService) {		
		this.helloService = helloService;
		this.worldService = worldService;
	}
	
	public void saveText(String helloText, String worldText) {
		
		helloService.saveText(HELLO_ENTITY_ID, helloText);
		worldService.saveText(WORLD_ENTITY_ID, worldText).getId();
		
	}	
	
	public void saveTextWithErrorTransactionPropagationMandatory(String helloText, String worldText) {
		
		helloService.saveText(ERROR_TRANSACTION_HELLO_ENTITY_ID, helloText);		
		worldService.saveTextWithTransactionPropagationMandatory(ERROR_TRANSACTION_WORLD_ENTITY_ID, worldText).getId();
			
	}
	
	public String readText() {
		
		String textHello = helloService.readText(HELLO_ENTITY_ID);		
		String textWorld = worldService.readText(WORLD_ENTITY_ID);		
		return textHello + " " + textWorld;
		
	}
	
	public String readTextWithErrorTransactionPropagationRequired() {
		
		String textHello = helloService.readText(ERROR_TRANSACTION_HELLO_ENTITY_ID);		
		String textWorld = worldService.readText(ERROR_TRANSACTION_WORLD_ENTITY_ID);		
		return textHello + " " + textWorld;
		
	}
	
}
