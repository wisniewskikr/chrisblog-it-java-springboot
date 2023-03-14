package com.example.app.services.internet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class InternetService {
	
	public String providePageAsString(String url) {
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		BufferedReader in = null;
		
		try {
			
			URL pageUrl = new URL(url);
			in = new BufferedReader(new InputStreamReader(pageUrl.openStream()));
			while ((line = in.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(System.lineSeparator());
			}
			
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			close(in);
		}
		
		return stringBuilder.toString();
		
	}
	
	private void close(BufferedReader in) {
		
		if (in != null) {
			try {
				in.close();
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		
	}

}
