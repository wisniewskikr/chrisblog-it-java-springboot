package com.example.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		
		logs.add("First Method - Entities are saved");
		PhantomReadEntity entity = new PhantomReadEntity();
		entity.setId(1L);
		entity.setText("Hello World");
		phantomReadRepository.saveAndFlush(entity);
		entity = new PhantomReadEntity();
		entity.setId(2L);
		entity.setText("Hello World 2");
		phantomReadRepository.saveAndFlush(entity);

		Thread.sleep(2000);
		
		logs.add("First Method - Entity is removed");
		phantomReadRepository.deleteById(2L);
		
		
	}
	
	@Async
	@Transactional(isolation = Isolation.DEFAULT)
	public Future<Map<PhantomReadJson, List<String>>> runSecondMethod() throws InterruptedException {
				
		List<PhantomReadEntity> entities = null;
		StringBuilder firstMessage = new StringBuilder();
		StringBuilder secondMessage = new StringBuilder();
		
		Thread.sleep(1000);
		
		entities = phantomReadRepository.findAll();
		for (PhantomReadEntity entity : entities) {
			String text = entity.getText();
			firstMessage.append(",");
			firstMessage.append(text);			
			logs.add("Second Method - Text before delete: " + text);
		}
		
		Thread.sleep(2000);
		
		entities = phantomReadRepository.findAll();
		for (PhantomReadEntity entity : entities) {
			String text = entity.getText();
			secondMessage.append(",");
			secondMessage.append(text);			
			logs.add("Second Method - Text after delete: " + text);
		}
		
		// Return result
		PhantomReadJson json = new PhantomReadJson(firstMessage.toString().replaceFirst(",", ""), secondMessage.toString().replaceFirst(",", ""));		
		Map<PhantomReadJson, List<String>> result = new HashMap<PhantomReadJson, List<String>>();
		result.put(json, logs);		
		return new AsyncResult<Map<PhantomReadJson, List<String>>>(result);
		
	}

}
