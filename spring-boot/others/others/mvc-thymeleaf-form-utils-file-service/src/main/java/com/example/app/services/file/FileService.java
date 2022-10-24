package com.example.app.services.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class FileService {

	public void writeToFile(String filePath, String content) {
				
		FileWriter in = null;
		try {
			
			in = new FileWriter(filePath);
			in.write(content);
			
		} catch (Exception e) {
			System.err.println(e);
		} finally {			
			closeFileWriter(in);			
		}
		
	}
	
	public String readFromFile(String filePath) {
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		BufferedReader in = null;
		
		try {
			
			in = new BufferedReader(new FileReader(filePath));
			while ((line = in.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(System.lineSeparator());				
			}
			
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			closeBufferReader(in);
		}
		
		return stringBuilder.toString();
		
	}
	
	private void closeFileWriter(FileWriter in) {
		
		if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
				System.err.println(e);
			}
		}
		
	}
	
	private void closeBufferReader(BufferedReader in) {
		
		if (in != null) {
			try {
				in.close();
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		
	}
	
}
