package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		WorldEntity entity = new WorldEntity();
		entity.setId(entityId);
		entity.setText(text);
		return worldRepository.save(entity);
	}
	
	public String readText(Long entityId) {
		return worldRepository.findById(entityId).get().getText();
	}

}
