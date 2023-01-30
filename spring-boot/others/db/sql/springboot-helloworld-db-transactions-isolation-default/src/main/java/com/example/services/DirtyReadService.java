package com.example.services;

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

	@Autowired
	public DirtyReadService(DirtyReadRepository helloWorldRepository) {
		this.dirtyReadRepository = helloWorldRepository;
	}
	
	@Async
	@Transactional
	public void runFirstMethod() throws InterruptedException {
		
		System.out.println("First Method - Entity is saved");
		DirtyReadEntity entity = new DirtyReadEntity();
		entity.setId(1L);
		entity.setText("Hello World");
		dirtyReadRepository.saveAndFlush(entity);

		Thread.sleep(2000);
		
		System.out.println("First Method - Operation is rolled out");
		if (true)
			throw new RuntimeException();
		
	}
	
	@Async
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Future<DirtyReadJson> runSecondMethod() throws InterruptedException {
				
		Optional<DirtyReadEntity> optional = null;
		
		Thread.sleep(1000);
		
		optional = dirtyReadRepository.findById(1L);
		String textBeforeRollOut = (optional.isPresent()) ? optional.get().getText() : "";		
		System.out.println("Second Method - Text before rolling out: " + textBeforeRollOut);
		
		Thread.sleep(2000);
		
		optional = dirtyReadRepository.findById(1L);
		String textAfterRollOut = (optional.isPresent()) ? optional.get().getText() : "";		
		System.out.println("Second Method - Text after rolling out: " + textAfterRollOut);
		
		DirtyReadJson json = new DirtyReadJson(textBeforeRollOut, textAfterRollOut);
		
		return new AsyncResult<DirtyReadJson>(json);
		
	}


}
