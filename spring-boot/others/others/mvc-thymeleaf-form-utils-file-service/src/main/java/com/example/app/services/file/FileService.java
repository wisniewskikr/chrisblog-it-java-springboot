package com.example.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

@Service
public class FileService {

	public void writeToFile(String filePath, String content) {		
				
		FileWriter in = null;
		try {
			
			Path path = getPath(filePath);			
			in = new FileWriter(path.toString());
			in.write(content);
			
		} catch (Exception e) {
			System.err.println(e);
		} finally {			
			closeFileWriter(in);			
		}
		
	}
	
	public String readFromFile(String filePath) {
		
		Path path = Paths.get(filePath);
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		BufferedReader in = null;
		
		try {
			
			in = new BufferedReader(new FileReader(path.toString()));
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
	
	private Path getPath(String filePath) throws IOException {
		
		Path path = Paths.get(filePath);
		createFolder(filePath, path);
		return path;
		
	}
	
	private void createFolder(String filePath, Path path) throws IOException {
		
		Path folderPath = Paths.get(filePath.replace(path.getFileName().toString(), ""));
		Files.createDirectories(folderPath);
		
	}
	
}
