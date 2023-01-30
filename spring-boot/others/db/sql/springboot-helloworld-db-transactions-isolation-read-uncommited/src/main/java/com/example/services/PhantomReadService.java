package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.PhantomReadEntity;
import com.example.jsons.PhantomReadJson;
import com.example.repositories.PhantomReadRepository;

@Service
public class PhantomReadService {
	
	private PhantomReadRepository phantomReadRepository;
	private List<String> logs = new ArrayList<String>();
	
	@Autowired
	public PhantomReadService(PhantomReadRepository phantomReadRepository) {
		this.phantomReadRepository = phantomReadRepository;
	}

	@Async
	@Transactional
	public void runFirstMethod() throws InterruptedException {
		
		logs.add("First Method - Entity is saved");
		PhantomReadEntity entity = new PhantomReadEntity();
		entity.setId(1L);
		entity.setText("Hello World");
		phantomReadRepository.saveAndFlush(entity);

		Thread.sleep(2000);
		
		logs.add("First Method - Operation is rolled out");
		if (true)
			throw new RuntimeException();
		
	}
	
	@Async
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Future<PhantomReadJson> runSecondMethod() throws InterruptedException {
				
		Optional<PhantomReadEntity> optional = null;
		
		Thread.sleep(1000);
		
		optional = phantomReadRepository.findById(1L);
		String firstMessage = (optional.isPresent()) ? optional.get().getText() : "";		
		logs.add("Second Method - Text before rolling out: " + firstMessage);
		
		Thread.sleep(2000);
		
		optional = phantomReadRepository.findById(1L);
		String secondMessage = (optional.isPresent()) ? optional.get().getText() : "";		
		logs.add("Second Method - Text after rolling out: " + secondMessage);
		
		PhantomReadJson json = new PhantomReadJson(firstMessage, secondMessage);
		
		displayLogs();
		
		return new AsyncResult<PhantomReadJson>(json);
		
	}
	
	private void displayLogs() {
		
		System.out.println("***** PHANTOM READ START *****");
		for (String log : logs) {
			System.out.println(log);
		}
		System.out.println("***** PHANTOM READ END *****");
		
	}


}
