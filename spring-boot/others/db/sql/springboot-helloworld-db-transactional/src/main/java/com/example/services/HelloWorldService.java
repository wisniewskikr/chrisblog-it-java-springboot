package com.example.services;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

	private HelloService helloService;
	private WorldService worldService;
	
	public HelloWorldService(HelloService helloService, WorldService worldService) {		
		this.helloService = helloService;
		this.worldService = worldService;
	}
	
	public void saveText(String helloText, String worldText) {
		
		try {
			helloService.saveText(helloText);
		} catch (Exception e) {
			System.err.println(e);
		}
		
		try {
			worldService.saveText(worldText).getId();
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	public String readText() {
		
		String textHello = helloService.readText();		
		String textWorld = worldService.readText();		
		return textHello + " " + textWorld;
		
	}
	
}
