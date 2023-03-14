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

import com.example.entities.NotRepetableReadEntity;
import com.example.jsons.NotRepetableReadJson;
import com.example.repositories.NotRepetableReadRepository;

@Service
public class NotRepetableReadService {
	
	private NotRepetableReadRepository notRepetableReadRepository;
	private List<String> logs = new ArrayList<String>();

	@Autowired
	public NotRepetableReadService(NotRepetableReadRepository notRepetableReadRepository) {
		this.notRepetableReadRepository = notRepetableReadRepository;
	}

	@Async
	@Transactional
	public void runFirstMethod() throws InterruptedException {
		
		logs.add("First Method - Entity is saved");
		NotRepetableReadEntity entity = new NotRepetableReadEntity();
		entity.setId(1L);
		entity.setText("Hello World");
		notRepetableReadRepository.saveAndFlush(entity);

		Thread.sleep(2000);
		
		logs.add("First Method - Entity is updated");
		entity.setText("Hello World Updated");
		notRepetableReadRepository.saveAndFlush(entity);
		
		
	}
	
	@Async
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public Future<Map<NotRepetableReadJson, List<String>>> runSecondMethod() throws InterruptedException {
				
		Optional<NotRepetableReadEntity> optional = null;
		
		Thread.sleep(1000);
		
		optional = notRepetableReadRepository.findById(1L);
		String firstMessage = (optional.isPresent()) ? optional.get().getText() : "";		
		logs.add("Second Method - Text before updata: " + firstMessage);
		
		Thread.sleep(2000);
		
		optional = notRepetableReadRepository.findById(1L);
		String secondMessage = (optional.isPresent()) ? optional.get().getText() : "";		
		logs.add("Second Method - Text after update: " + secondMessage);
		
		// Return result
		NotRepetableReadJson json = new NotRepetableReadJson(firstMessage, secondMessage);		
		Map<NotRepetableReadJson, List<String>> result = new HashMap<NotRepetableReadJson, List<String>>();
		result.put(json, logs);		
		return new AsyncResult<Map<NotRepetableReadJson, List<String>>>(result);
		
	}

}
