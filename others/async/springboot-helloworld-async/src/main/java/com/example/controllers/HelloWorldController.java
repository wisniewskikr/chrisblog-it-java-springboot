package com.example.controllers;

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
	public HelloWorldJson helloWorld() throws InterruptedException {
		
		asyncService.runFirsMethod();
		asyncService.runSecondMethod();
		
		return new HelloWorldJson("Async methods runFirstMethod() and runSecondMethod() were started. But because runFirstMethod() was paused so result is: "
				+ "First Method Start - Second Metod Start - Second Method End - First Method End. Please check console logs.");
		
	}
	
}