package com.example.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SentenceService {	

	private WordService wordService;
	
	public SentenceService(WordService worldService) {		
		this.wordService = worldService;
	}
	
	@Transactional
	public void saveSentence(String firstWord, String secondWord) {
		
		wordService.saveFirstWord(firstWord);
		wordService.saveSecondWord(secondWord);
		
	}

	public String readSentence() {
		
		String firstWord = wordService.readFirstWord();
		String secondWord = wordService.readSecondWord();
		return firstWord + " " + secondWord;
		
	}
	
}
