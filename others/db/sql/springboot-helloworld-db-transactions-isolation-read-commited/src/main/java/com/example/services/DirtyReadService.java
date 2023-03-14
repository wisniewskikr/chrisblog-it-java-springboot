package com.example.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.DirtyReadEntity;
import com.example.jsons.DirtyReadJson;
import com.example.repositories.DirtyReadRepository;

@Service
public class DirtyReadService {
	
	private DirtyReadRepository dirtyReadRepository;
	private List<String> logs = new ArrayList<String>();

	@Autowired
	public DirtyReadService(DirtyReadRepository helloWorldRepository) {
		this.dirtyReadRepository = helloWorldRepository;
	}
	
	@Async
	@Transactional
	public void runFirstMethod() throws InterruptedException {
		
		logs.add("First Method - Entity is saved");
		DirtyReadEntity entity = new DirtyReadEntity();
		entity.setId(1L);
		entity.setText("Hello World");
		dirtyReadRepository.saveAndFlush(entity);

		Thread.sleep(2000);
		
		logs.add("First Method - Operation is rolled out");
		if (true)
			throw new RuntimeException();
		
	}
	
	@Async
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public Future<Map<DirtyReadJson, List<String>>> runSecondMethod() throws InterruptedException {
				
		Optional<DirtyReadEntity> optional = null;
		
		Thread.sleep(1000);
		
		optional = dirtyReadRepository.findById(1L);
		String firstMessage = (optional.isPresent()) ? optional.get().getText() : "";		
		logs.add("Second Method - Text before rolling out: " + firstMessage);
		
		Thread.sleep(2000);
		
		optional = dirtyReadRepository.findById(1L);
		String secondMessage = (optional.isPresent()) ? optional.get().getText() : "";		
		logs.add("Second Method - Text after rolling out: " + secondMessage);
		
		// Return result
		DirtyReadJson json = new DirtyReadJson(firstMessage, secondMessage);		
		Map<DirtyReadJson, List<String>> result = new HashMap<DirtyReadJson, List<String>>();
		result.put(json, logs);		
		return new AsyncResult<Map<DirtyReadJson, List<String>>>(result);
		
	}

}
