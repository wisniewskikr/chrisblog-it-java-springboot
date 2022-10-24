package com.example.app.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyService {
	
	@Value(value = "${properties.file.name}")
	private String propertiesFileName;

	public Properties getPropertiesFromFile(String fileName) {
		
		Properties properties = new Properties();
		
		try {
			InputStream stream = this.getClass().getClassLoader().getResourceAsStream(propertiesFileName);
			properties.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
		
	}
	
}
