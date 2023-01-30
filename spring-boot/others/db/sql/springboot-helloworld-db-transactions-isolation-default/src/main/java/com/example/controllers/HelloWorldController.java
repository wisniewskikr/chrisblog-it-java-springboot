package com.example.controllers;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsons.DirtyReadJson;
import com.example.services.DirtyReadService;

@RestController
public class HelloWorldController {
	
	private DirtyReadService dirtyReadService;

	public HelloWorldController(DirtyReadService dirtyReadService) {
		this.dirtyReadService = dirtyReadService;
	}

	@RequestMapping(value="/")
	public DirtyReadJson helloWorld() throws InterruptedException, ExecutionException {
			
		runDirtyReadFirstMethod();
		Future<DirtyReadJson> futureDirtyRead = runDirtyReadSecondMethod();
		
		while (!futureDirtyRead.isDone()) {
			Thread.sleep(2000);			
		}
		
		return futureDirtyRead.get();	
	}
	
	private void runDirtyReadFirstMethod() {
		
		try {
			dirtyReadService.runFirstMethod();
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	private Future<DirtyReadJson> runDirtyReadSecondMethod() {
		
		Future<DirtyReadJson> future = null;
		
		try {
			future = dirtyReadService.runSecondMethod();
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return future;
		
	}
	
}