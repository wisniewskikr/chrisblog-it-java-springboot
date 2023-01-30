package com.example.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
	
	@Async
	public void runFirsMethod() throws InterruptedException {
		
		System.out.println("First Metod Start");		
		Thread.sleep(1000);		
		System.out.println("First Metod End");
		
	}
	
	@Async
	public void runSecondMethod() {
		
		System.out.println("Second Metod Start");		
		System.out.println("Second Metod End");
		
	}

}
