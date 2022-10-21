package com.example.app;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.SerializationUtils;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		
		int[] array = {45,12,85,32,89,39,69,44,42,1,6,8};
		int[] arrayCopy = null;
		
//		arrayCopy = main.getArrayCopyByLoop(array);
//		arrayCopy = main.getArrayCopyByJson(array);
		arrayCopy = main.getArrayCopyBySerialization(array);
//		arrayCopy = main.getArrayCopyByCloneMethod(array);
//		arrayCopy = main.getArrayCopyByStream(array);
//		arrayCopy = main.getArrayCopyByArrays(array);
//		arrayCopy = main.getArrayCopyBySystem(array);
				
		System.out.println("Array: " + Arrays.toString(array));	
		System.out.println("Array Copy: " + Arrays.toString(arrayCopy));	
		main.shuffleArray(arrayCopy);
		System.out.println("Array after Array Copy shuffle: " + Arrays.toString(array));
		System.out.println("Array Copy after shuffle: " + Arrays.toString(arrayCopy));	

	}
	
	public int[] getArrayCopyByLoop(int[] array) {
		
		int[] arrayCopy = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			arrayCopy[i] = array[i];
		}
		
		return arrayCopy;
		
	}
	
	public int[] getArrayCopyByJson(int[] array) {
		
		Gson gson = new Gson();
		String json = gson.toJson(array);
		return gson.fromJson(json, int[].class);
		
	}
	
	public int[] getArrayCopyBySerialization(int[] array) {		
		return SerializationUtils.clone(array);		
	}
	
	public int[] getArrayCopyByCloneMethod(int[] array) {		
		return array.clone();		
	}
	
	public int[] getArrayCopyByStream(int[] array) {
		return Arrays.stream(array).toArray();
	}	
	
	public int[] getArrayCopyByArrays(int[] array) {		
		return Arrays.copyOf(array, array.length);		
	}
	
	public int[] getArrayCopyBySystem(int[] array) {
		
		int[] arrayCopy = new int[array.length];
		System.arraycopy(array, 0, arrayCopy, 0, arrayCopy.length);
		return arrayCopy;
		
	}	
	
	// ***** HELP METHODS ***** //
	
	public void shuffleArray(int[] array) {
		
		for (int i = 0; i < array.length; i++) {
			array[i] = new Random().nextInt(100);
		}
		
	}

}
