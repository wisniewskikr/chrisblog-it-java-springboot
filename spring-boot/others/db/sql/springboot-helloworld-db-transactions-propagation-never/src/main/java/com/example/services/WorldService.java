package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.WorldEntity;
import com.example.repositories.WorldRepository;

@Service
public class WorldService {
	
	private WorldRepository worldRepository;
	
	@Autowired
	public WorldService(WorldRepository worldRepository) {
		this.worldRepository = worldRepository;
	}

	public WorldEntity saveText(Long entityId, String text) {
		
		WorldEntity result = null;
		
		try {
			WorldEntity entity = new WorldEntity();
			entity.setId(entityId);
			entity.setText(text);
			result = worldRepository.save(entity);
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return result;
		
	}	
	
	@Transactional(propagation = Propagation.NEVER)
	public WorldEntity saveTextWithTransactionPropagationMandatory(Long entityId, String text) {
		
		WorldEntity result = null;
		
		try {
			WorldEntity entity = new WorldEntity();
			entity.setId(entityId);
			entity.setText(text);
			result = worldRepository.save(entity);			
			
		} catch (Exception e) {
			System.err.println(e);
		}		
		
		return result;
		
	}
	
	public String readText(Long entityId) {
		Optional<WorldEntity> entity = worldRepository.findById(entityId);
		return (entity.isPresent()) ? entity.get().getText() : null;
	}	

}
