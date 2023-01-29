package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.WordEntity;
import com.example.repositories.WordRepository;

@Service
public class WordService {
	
	private static final Long FIRST_WORD_ID = Long.valueOf(1);
	private static final Long SECOND_WORD_ID = Long.valueOf(2);
	
	private WordRepository worldRepository;
	
	@Autowired
	public WordService(WordRepository worldRepository) {
		this.worldRepository = worldRepository;
	}

	public WordEntity saveFirstWord(String firstWord) {
		
		WordEntity result = null;
		
		try {
			WordEntity entity = new WordEntity();
			entity.setId(FIRST_WORD_ID);
			entity.setText(firstWord);
			result = worldRepository.save(entity);
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return result;
		
	}
	
	public String readFirstWord() {
		Optional<WordEntity> entity = worldRepository.findById(FIRST_WORD_ID);
		return (entity.isPresent()) ? entity.get().getText() : null;
	}
	
	@SuppressWarnings("unused")
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public WordEntity saveSecondWord(String secondWord) {
		
		WordEntity result = null;		
			
		WordEntity entity = new WordEntity();
		entity.setId(SECOND_WORD_ID);
		entity.setText(secondWord);
		result = worldRepository.save(entity);
		
		if (true)
			throw new RuntimeException();
		
		return result;
		
	}
	
	public String readSecondWord() {
		Optional<WordEntity> entity = worldRepository.findById(SECOND_WORD_ID);
		return (entity.isPresent()) ? entity.get().getText() : null;
	}

}
