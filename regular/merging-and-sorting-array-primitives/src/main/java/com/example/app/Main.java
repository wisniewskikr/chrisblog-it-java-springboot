package com.example.app;

public class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		
		int [] sortedAsc1 = {1,5,8};
		int [] sortedAsc2 = {2,8,10};
		int [] sortedDesc1 = {8,5,1};
		int [] sortedDesc2 = {10,8,2};
		int [] array1 = {8,1,5};
		int [] array2 = {8,10,2};
		int[] mergedArray = null;
		
//		mergedArray = main.mergeSortedArraysIntAsc(sortedAsc1, sortedAsc2);
//		mergedArray = main.mergeSortedArraysIntDesc(sortedDesc1, sortedDesc2);
//		mergedArray = main.mergeAndSortArraysIntAsc(array1, array2);
		mergedArray = main.mergeAndSortArraysIntDesc(array1, array2);
		
		for (int i = 0; i < mergedArray.length; i++) {
			System.out.println(mergedArray[i]);
		}		  

	}
	
	public int[] mergeSortedArraysIntAsc(int[] sortedAsc1, int[] sortedAsc2) {
		
		int[] answer = new int[sortedAsc1.length + sortedAsc2.length];
	    int i = 0, j = 0, k = 0;

	    while (i < sortedAsc1.length && j < sortedAsc2.length)  
	       answer[k++] = sortedAsc1[i] < sortedAsc2[j] ? sortedAsc1[i++] :  sortedAsc2[j++];

	    while (i < sortedAsc1.length)  
	        answer[k++] = sortedAsc1[i++];

	    while (j < sortedAsc2.length)    
	        answer[k++] = sortedAsc2[j++];

	    return answer;
		
	}	
	
	public int[] mergeSortedArraysIntDesc(int[] sorted1, int[] sorted2) {
		
		int[] answer = new int[sorted1.length + sorted2.length];
	    int i = 0, j = 0, k = 0;

	    while (i < sorted1.length && j < sorted2.length)  
	       answer[k++] = sorted1[i] > sorted2[j] ? sorted1[i++] :  sorted2[j++];

	    while (i < sorted1.length)  
	        answer[k++] = sorted1[i++];

	    while (j < sorted2.length)    
	        answer[k++] = sorted2[j++];

	    return answer;
		
	}
	
	public int[] mergeAndSortArraysIntAsc(int[] array1, int[] array2) {
		
		int[] sortedAsc1 = sortArrayIntAsc(array1);
		int[] sortedAsc2 = sortArrayIntAsc(array2);
		return mergeSortedArraysIntAsc(sortedAsc1, sortedAsc2);
		
	}
	
	public int[] mergeAndSortArraysIntDesc(int[] array1, int[] array2) {
		
		int[] sortedDesc1 = sortArrayIntDesc(array1);
		int[] sortedDesc2 = sortArrayIntDesc(array2);
		return mergeSortedArraysIntDesc(sortedDesc1, sortedDesc2);
		
	}
	
	// ***** HELP METHODS ***** //
	
	public int[] sortArrayIntAsc(int[] array) {
		
		int temp;
		
		for (int i = 1; i < array.length; i++) {
			
			for (int j = i; j > 0; j--) {
				if (array[j] < array [j - 1]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
			
		}
		
		return array;
		
	}
	
	public int[] sortArrayIntDesc(int[] array) {
		
		int temp;
		
		for (int i = 1; i < array.length; i++) {
			
			for (int j = i; j > 0; j--) {
				if (array[j] > array [j - 1]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
			
		}
		
		return array;
		
	}

}
