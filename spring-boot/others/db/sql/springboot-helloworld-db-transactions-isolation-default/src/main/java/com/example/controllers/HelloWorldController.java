package com.example.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.DirtyReadService;

@RestController
public class HelloWorldController {
	
	private DirtyReadService dirtyReadService;

	public HelloWorldController(DirtyReadService dirtyReadService) {
		this.dirtyReadService = dirtyReadService;
	}

	@RequestMapping(value="/")
	public String helloWorld() throws InterruptedException {
			
		runDirtyReadFirstMethod();
		runDirtyReadSecondMethod();
		
		return "Hello World";		
	}
	
	private void runDirtyReadFirstMethod() {
		
		try {
			dirtyReadService.runFirstMethod();
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	private void runDirtyReadSecondMethod() {
		
		try {
			dirtyReadService.runSecondMethod();
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
}