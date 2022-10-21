package com.example.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {		
				 
		int[] array = {5,2,5,7,9,3,7,4};
		
		int[] notRepeatingElements = getNotRepeatingElements(array);
		
		System.out.println("Not repeating elements: " + Arrays.toString(notRepeatingElements));

	}
	
	private static int[] getNotRepeatingElements(int[] array) {
		
		Set<Integer> tmpSet = new HashSet<Integer>();
		List<Integer> tmpList = new ArrayList<Integer>();
		
		boolean notExists = false;
		for (int i : array) {			
			notExists = tmpSet.add(Integer.valueOf(i));
			
			if (notExists) {
				tmpList.add(Integer.valueOf(i));
			} else {
				tmpList.remove(Integer.valueOf(i));
			}					 	
			
		}
		
		return tmpList.stream().mapToInt(Integer::intValue).toArray();
		
	}	
	
	
}