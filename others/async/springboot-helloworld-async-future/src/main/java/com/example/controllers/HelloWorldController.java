package com.example.controllers;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsons.HelloWorldJson;
import com.example.services.AsyncService;

@RestController
public class HelloWorldController {
	
	private AsyncService asyncService;

	@Autowired
	public HelloWorldController(AsyncService asyncService) {
		this.asyncService = asyncService;
	}

	@RequestMapping(value="/")
	public HelloWorldJson helloWorld() throws InterruptedException, ExecutionException {
		
		Future<String> futureAsyncMethod = asyncService.runAsyncMethod();
		
		while (!futureAsyncMethod.isDone()) {
			Thread.sleep(1000);			
		}
		
		return new HelloWorldJson(futureAsyncMethod.get());
		
	}
	
}