package com.example.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.TextDto;
import com.example.jsons.DisplayJson;
import com.example.retrofit.services.TextService;

import retrofit2.Response;

@RestController
public class DisplayController {
	
	private Environment environment;

	private TextService textService;
	
	@Autowired
	public DisplayController(Environment environment, TextService textService) {
		this.environment = environment;
		this.textService = textService;
	}

	@RequestMapping(value="/")
	public DisplayJson greeting() {
		
		String displayPort = environment.getProperty("local.server.port");
		TextDto textDto = getTextDto();

		return new DisplayJson(textDto.getMessage(), displayPort, textDto.getPort());
		
	}
	
	private TextDto getTextDto() {
		
		TextDto textDto = new TextDto();
		
        try {
            Response<TextDto> bookResponse = textService.getText().execute();
            textDto = bookResponse.body();
        } catch (IOException e) {
        	System.err.println(e);
        }
        
        return textDto;
		
	}
	
}