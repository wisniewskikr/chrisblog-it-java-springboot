package com.example.app.automatedtests.constant.envs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class EnvVariables {
	
	private static Properties applicationProperties;
	
	public static String PORT;
	
	static {
		setParameters();
	}

	public EnvVariables() {
		setParameters();
	}
	
	private static void setParameters(){
		
		try {

			applicationProperties = new Properties();
			String applicationPropertyName = EnvProperties.getApplicationPropertyName();
			InputStream inputStream = EnvVariables.class.getClassLoader().getResourceAsStream(applicationPropertyName);
			applicationProperties.load(inputStream);

			for (String propName : applicationProperties.stringPropertyNames()){
				for (String propName1 : applicationProperties.stringPropertyNames()){
					String propertyValue = applicationProperties.getProperty(propName);
					String format = String.format("\\$\\{%s\\}", propName1);


					String property = applicationProperties.getProperty(propName1);
					String s = propertyValue.replaceAll(format, property);
					if (!propertyValue.equalsIgnoreCase(s)){
						applicationProperties.setProperty(propName, s);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PORT = EnvProperties.getProperty("port");
		
	}

}
