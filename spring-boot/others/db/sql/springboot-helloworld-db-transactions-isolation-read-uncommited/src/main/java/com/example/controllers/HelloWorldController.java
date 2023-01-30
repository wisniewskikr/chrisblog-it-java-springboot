package com.example.controllers;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsons.DirtyReadJson;
import com.example.jsons.HelloWorldJson;
import com.example.jsons.NotRepetableReadJson;
import com.example.jsons.PhantomReadJson;
import com.example.services.DirtyReadService;
import com.example.services.NotRepetableReadService;
import com.example.services.PhantomReadService;

@RestController
public class HelloWorldController {
	
	private DirtyReadService dirtyReadService;
	private NotRepetableReadService notRepetableReadService;
	private PhantomReadService phantomReadService;
	
	@Autowired
	public HelloWorldController(DirtyReadService dirtyReadService, NotRepetableReadService notRepetableReadService,
			PhantomReadService phantomReadService) {
		this.dirtyReadService = dirtyReadService;
		this.notRepetableReadService = notRepetableReadService;
		this.phantomReadService = phantomReadService;
	}

	@RequestMapping(value="/")
	public HelloWorldJson helloWorld() throws InterruptedException, ExecutionException {
			
		runDirtyReadFirstMethod();
		Future<DirtyReadJson> futureDirtyRead = runDirtyReadSecondMethod();
		runNotRepetableReadFirstMethod();
		Future<NotRepetableReadJson> futureNotRepetableRead = runNotRepetableReadSecondMethod();
		runPhantomReadFirstMethod();
		Future<PhantomReadJson> futurePhantomRead = runPhantomReadSecondMethod();
		
		while (!futureDirtyRead.isDone() && 
				!futureNotRepetableRead.isDone() &&
				!futurePhantomRead.isDone()) {
			Thread.sleep(2000);			
		}
		
		return new HelloWorldJson(futureDirtyRead.get(), futureNotRepetableRead.get(), futurePhantomRead.get());	
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
	
	private void runNotRepetableReadFirstMethod() {
		
		try {
			notRepetableReadService.runFirstMethod();
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	private Future<NotRepetableReadJson> runNotRepetableReadSecondMethod() {
		
		Future<NotRepetableReadJson> future = null;
		
		try {
			future = notRepetableReadService.runSecondMethod();
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return future;
		
	}
	
	private void runPhantomReadFirstMethod() {
		
		try {
			phantomReadService.runFirstMethod();
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	private Future<PhantomReadJson> runPhantomReadSecondMethod() {
		
		Future<PhantomReadJson> future = null;
		
		try {
			future = phantomReadService.runSecondMethod();
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return future;
		
	}
	
}