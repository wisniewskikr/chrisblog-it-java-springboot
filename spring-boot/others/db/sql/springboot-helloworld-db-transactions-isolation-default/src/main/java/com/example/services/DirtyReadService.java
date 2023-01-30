package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.DirtyReadEntity;
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
		
		System.out.println("Here 1.1");
		
		DirtyReadEntity entity = new DirtyReadEntity();
		entity.setId(1L);
		entity.setText("Hello World");
		dirtyReadRepository.save(entity);
		
		System.out.println("Here 1.2");
		
		Thread.sleep(2000);
		
		System.out.println("Here 1.3");
		
		if (true)
			throw new RuntimeException();
		
	}
	
	@Async
	public void runSecondMethod() throws InterruptedException {
				
		Optional<DirtyReadEntity> optional = null;
		String text = null;
		
		System.out.println("Here 2.1");
		
		Thread.sleep(1000);
		
		System.out.println("Here 2.2");
		
		optional = dirtyReadRepository.findById(1L);
		text = (optional.isPresent()) ? optional.get().getText() : "";		
		System.out.println("First read: " + text);
		
		System.out.println("Here 2.3");
		
		Thread.sleep(2000);
		
		System.out.println("Here 2.4");
		
		optional = dirtyReadRepository.findById(1L);
		text = (optional.isPresent()) ? optional.get().getText() : "";		
		System.out.println("Second read: " + text);
		
	}


}
