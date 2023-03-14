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
		
		try {
			wordService.saveFirstWord(firstWord);
		} catch (Exception e) {
			System.err.println(e);
		}
				
		try {
			wordService.saveSecondWord(secondWord);
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}

	public String readSentence() {
		
		String firstWord = wordService.readFirstWord();
		String secondWord = wordService.readSecondWord();
		return firstWord + " " + secondWord;
		
	}
	
}
