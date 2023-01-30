package com.example.services;

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

	@Autowired
	public NotRepetableReadService(NotRepetableReadRepository notRepetableReadRepository) {
		this.notRepetableReadRepository = notRepetableReadRepository;
	}

	@Async
	@Transactional
	public void runFirstMethod() throws InterruptedException {
		
		System.out.println("First Method - Entity is saved");
		NotRepetableReadEntity entity = new NotRepetableReadEntity();
		entity.setId(1L);
		entity.setText("Hello World");
		notRepetableReadRepository.saveAndFlush(entity);

		Thread.sleep(2000);
		
		System.out.println("First Method - Entity is updated");
		entity.setText("Hello World Updated");
		notRepetableReadRepository.saveAndFlush(entity);
		
		
	}
	
	@Async
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Future<NotRepetableReadJson> runSecondMethod() throws InterruptedException {
				
		Optional<NotRepetableReadEntity> optional = null;
		
		Thread.sleep(1000);
		
		optional = notRepetableReadRepository.findById(1L);
		String firstMessage = (optional.isPresent()) ? optional.get().getText() : "";		
		System.out.println("Second Method - Text before updata: " + firstMessage);
		
		Thread.sleep(2000);
		
		optional = notRepetableReadRepository.findById(1L);
		String secondMessage = (optional.isPresent()) ? optional.get().getText() : "";		
		System.out.println("Second Method - Text after update: " + secondMessage);
		
		NotRepetableReadJson json = new NotRepetableReadJson(firstMessage, secondMessage);
		
		return new AsyncResult<NotRepetableReadJson>(json);
		
	}

}
