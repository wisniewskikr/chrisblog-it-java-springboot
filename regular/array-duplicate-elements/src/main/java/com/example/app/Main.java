package com.example.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

	public static void main(String[] args) {		
				 
		int[] array = {5,2,5,7,9,3,7,4};
		
//		array = findDuplicatesByHashSet(array);
//		array = findDuplicatesByHashMap(array);
		array = findDuplicatesByBruteForce(array);
		
		System.out.println("Duplicate elements: " + Arrays.toString(array));

	}
	
	static int[] findDuplicatesByHashSet(int[] array) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		Set<Integer> store = new HashSet<Integer>();		
		for (Integer element : array) { 
			if (store.add(element) == false) { 
				result.add(element);
			} 
		}
		
		return result.stream().mapToInt(Integer::intValue).toArray();
		
	}
	
	static int[] findDuplicatesByHashMap(int[] array) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		Map<Integer, Integer> countMap = new HashMap<>();
		for (Integer element : array) {
			Integer count = countMap.get(element);
			if (count == null) {
				countMap.put(element, 1);
			} else {
				countMap.put(element, ++count);
			}
		}
		
		Set<Entry<Integer, Integer>> entrySet = countMap.entrySet();
		for (Entry<Integer, Integer> entry : entrySet) {
			if (entry.getValue() > 1) {
				result.add(entry.getKey());
			}
		}	
		
		return result.stream().mapToInt(Integer::intValue).toArray();
		
	}
	
	static int[] findDuplicatesByBruteForce(int[] array) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		for (int i = 0; i < array.length; i++) { 
			for (int j = i + 1; j < array.length; j++) { 
				if (array[i] == array[j]) { 
					result.add(Integer.valueOf(array[i]));
				}
			}
		}
		
		return result.stream().mapToInt(Integer::intValue).toArray();
		
	}
	
}