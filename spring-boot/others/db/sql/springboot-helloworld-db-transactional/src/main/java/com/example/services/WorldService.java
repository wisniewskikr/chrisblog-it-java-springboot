package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.WorldEntity;
import com.example.repositories.WorldRepository;

@Service
public class WorldService {
	
	private static final Long ENTITY_ID = Long.valueOf(1);
	
	private WorldRepository worldRepository;
	
	@Autowired
	public WorldService(WorldRepository worldRepository) {
		this.worldRepository = worldRepository;
	}

	public WorldEntity saveText(String text) {
		WorldEntity entity = new WorldEntity();
		entity.setId(ENTITY_ID);
		entity.setText(text);
		return worldRepository.save(entity);
	}
	
	public String readText() {
		return worldRepository.findById(ENTITY_ID).get().getText();
	}

}
