package com.example.controllers;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
		Future<Map<DirtyReadJson, List<String>>> futureDirtyRead = runDirtyReadSecondMethod();
		runNotRepetableReadFirstMethod();
		Future<Map<NotRepetableReadJson, List<String>>> futureNotRepetableRead = runNotRepetableReadSecondMethod();
		runPhantomReadFirstMethod();
		Future<Map<PhantomReadJson, List<String>>> futurePhantomRead = runPhantomReadSecondMethod();
		
		while (!futureDirtyRead.isDone() && 
				!futureNotRepetableRead.isDone() &&
				!futurePhantomRead.isDone()) {
			Thread.sleep(2000);			
		}
		
		Entry<DirtyReadJson, List<String>> dirtyReadEntry = futureDirtyRead.get().entrySet().iterator().next();
		DirtyReadJson dirtyReadJson = dirtyReadEntry.getKey();
		List<String> dirtyReadLogs = dirtyReadEntry.getValue();
		
		Entry<NotRepetableReadJson, List<String>> notRepetableReadEntry = futureNotRepetableRead.get().entrySet().iterator().next();
		NotRepetableReadJson notRepetableReadReadJson = notRepetableReadEntry.getKey();
		List<String> notRepetableReadLogs = notRepetableReadEntry.getValue();
		
		Entry<PhantomReadJson, List<String>> phantomReadEntry = futurePhantomRead.get().entrySet().iterator().next();
		PhantomReadJson phantomReadJson = phantomReadEntry.getKey();
		List<String> phantomReadLogs = phantomReadEntry.getValue();
		
		displayLogs(dirtyReadLogs, notRepetableReadLogs, phantomReadLogs);		
		return new HelloWorldJson(dirtyReadJson, notRepetableReadReadJson, phantomReadJson);	
	}	
	
	private void runDirtyReadFirstMethod() {
		
		try {
			dirtyReadService.runFirstMethod();
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	private Future<Map<DirtyReadJson, List<String>>> runDirtyReadSecondMethod() {
		
		Future<Map<DirtyReadJson, List<String>>> future = null;
		
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
	
	private Future<Map<NotRepetableReadJson, List<String>>> runNotRepetableReadSecondMethod() {
		
		Future<Map<NotRepetableReadJson, List<String>>> future = null;
		
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
	
	private Future<Map<PhantomReadJson, List<String>>> runPhantomReadSecondMethod() {
		
		Future<Map<PhantomReadJson, List<String>>> future = null;
		
		try {
			future = phantomReadService.runSecondMethod();
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return future;
		
	}
	
	private void displayLogs(List<String> dirtyReadLogs, List<String> notRepetableReadLogs, List<String> phantomReadLogs) {
		
		System.out.println("**** DIRTY READ LOGS BEGIN ***");
		for (String log : dirtyReadLogs) {
			System.out.println(log);
		}
		System.out.println("**** DIRTY READ LOGS END ***");
		
		System.out.println("");
		
		System.out.println("**** NOT REPETABLE READ LOGS BEGIN ***");
		for (String log : notRepetableReadLogs) {
			System.out.println(log);
		}
		System.out.println("**** NOT REPETABLE READ LOGS END ***");
		
		System.out.println("");
		
		System.out.println("**** PHANTOM READ LOGS BEGIN ***");
		for (String log : phantomReadLogs) {
			System.out.println(log);
		}
		System.out.println("**** PHANTOM READ LOGS END ***");
		
	}
	
}