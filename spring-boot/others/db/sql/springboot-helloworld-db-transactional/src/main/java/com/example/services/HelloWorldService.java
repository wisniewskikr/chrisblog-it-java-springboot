package com.example.services;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
	
	private static final Long HELLO_ENTITY_ID = Long.valueOf(1);
	private static final Long WORLD_ENTITY_ID = Long.valueOf(2);

	private HelloService helloService;
	private WorldService worldService;
	
	public HelloWorldService(HelloService helloService, WorldService worldService) {		
		this.helloService = helloService;
		this.worldService = worldService;
	}
	
	public void saveTextWithErrorWithoutTransaction(String helloText, String worldText) {
		
		try {
			helloService.saveText(HELLO_ENTITY_ID, helloText);
		} catch (Exception e) {
			System.err.println(e);
		}
		
		if (true)
			throw new RuntimeException();
		
		try {
			worldService.saveText(WORLD_ENTITY_ID, worldText).getId();
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	public String readTextWithErrorWithoutTransaction() {
		
		String textHello = helloService.readText(HELLO_ENTITY_ID);		
		String textWorld = worldService.readText(WORLD_ENTITY_ID);		
		return textHello + " " + textWorld;
		
	}
	
}
