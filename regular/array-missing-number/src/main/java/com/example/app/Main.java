package com.example.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class Main {

	public static void main(String[] args) {		
		
		int array[] = {1,2,3,4,5,6,8,9};
		
		array = getMissingNumbers(array, 9);
//		array = getMissingNumbersByBigSet(array, 9);
//		array = getMissingOnlyOneNumber(array, 9);		
				
		System.out.print("Missing numbers are: " + Arrays.toString(array));  
		

	}
	
	static int[] getMissingNumbers(int[] array, int elementCounts) {
		
		List<Integer> result = new ArrayList<Integer>();
		int[] store = new int[elementCounts + 1];
		
		for(int index : array) {
			store[index] = 1;
		}
		
		for(int i = 1; i < store.length; i++) {
			if (store[i] == 0)
				result.add(Integer.valueOf(i));
		}
		
		return result.stream().mapToInt(Integer::intValue).toArray();
		
	}
	
	static int[] getMissingOnlyOneNumber(int[] array, int elementCounts) {
		
		int[] result = new int[1];
		
		int expectedSum = elementCounts * ((elementCounts + 1) / 2); 
		int actualSum = 0; 
		
		for (int i : array) { 
			actualSum += i; 
		} 
		
		result[0] = expectedSum - actualSum;
		
		return result;
		
	}
	
	static int[] getMissingNumbersByBigSet(int[] array, int elementCounts) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		int missingCount = elementCounts - array.length; 
		BitSet bitSet = new BitSet(elementCounts); 
		for (int number : array) { 
			bitSet.set(number - 1); 
		} 
		
		int lastMissingIndex = 0; 
		for (int i = 0; i < missingCount; i++) { 
			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex); 
			result.add(++lastMissingIndex); 
		}
		
		return result.stream().mapToInt(Integer::intValue).toArray();
		
	}
	
}