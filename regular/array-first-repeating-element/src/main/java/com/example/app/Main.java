package com.example.app;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {		
				 
		int[] array = {5,2,5,7,9,3,7,4};
		
		int firstRepeatingElement = getFirstRepeatingElement(array);
		
		System.out.println("First repeating element: " + firstRepeatingElement);

	}
	
	private static int getFirstRepeatingElement(int[] array) {
		
		Set<Integer> tmpSet = new HashSet<Integer>();
		
		for (int i : array) {
			
			if (!tmpSet.add(Integer.valueOf(i)))
				return i;
			
		}
		
		return -1;
		
	}	
	
	
}