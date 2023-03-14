package com.example.services;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
	
	@Async
	public Future<String> runAsyncMethod() throws InterruptedException {					
		Thread.sleep(2000);		
		return new AsyncResult<String>("Hello World!");		
	}

}
