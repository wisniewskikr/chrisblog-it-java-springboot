package com.example.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HelloWorldService {
	
	private static final Long HELLO_ENTITY_ID = Long.valueOf(1);
	private static final Long WORLD_ENTITY_ID = Long.valueOf(1);
	private static final Long ERROR_NOT_TRANSACTION_HELLO_ENTITY_ID = Long.valueOf(2);
	private static final Long ERROR_NOT_TRANSACTION_WORLD_ENTITY_ID = Long.valueOf(2);
	private static final Long ERROR_TRANSACTION_HELLO_ENTITY_ID = Long.valueOf(3);
	private static final Long ERROR_TRANSACTION_WORLD_ENTITY_ID = Long.valueOf(3);

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
	
	@SuppressWarnings("unused")
	public void saveTextWithErrorWithoutTransaction(String helloText, String worldText) {
		
		helloService.saveText(ERROR_NOT_TRANSACTION_HELLO_ENTITY_ID, helloText);
		
		if (true)
			throw new RuntimeException();
		
		worldService.saveText(ERROR_NOT_TRANSACTION_WORLD_ENTITY_ID, worldText).getId();
		
	}
	
	@SuppressWarnings("unused")
	@Transactional
	public void saveTextWithErrorWithTransaction(String helloText, String worldText) {
		
		helloService.saveText(ERROR_TRANSACTION_HELLO_ENTITY_ID, helloText);
		
		if (true)
			throw new RuntimeException();
		
		worldService.saveText(ERROR_TRANSACTION_WORLD_ENTITY_ID, worldText).getId();
		
	}
	
	public String readText() {
		
		String textHello = helloService.readText(HELLO_ENTITY_ID);		
		String textWorld = worldService.readText(WORLD_ENTITY_ID);		
		return textHello + " " + textWorld;
		
	}
	
	public String readTextWithErrorWithoutTransaction() {
		
		String textHello = helloService.readText(ERROR_NOT_TRANSACTION_HELLO_ENTITY_ID);		
		String textWorld = worldService.readText(ERROR_NOT_TRANSACTION_WORLD_ENTITY_ID);		
		return textHello + " " + textWorld;
		
	}
	
	public String readTextWithErrorWithTransaction() {
		
		String textHello = helloService.readText(ERROR_TRANSACTION_HELLO_ENTITY_ID);		
		String textWorld = worldService.readText(ERROR_TRANSACTION_WORLD_ENTITY_ID);		
		return textHello + " " + textWorld;
		
	}
	
}
