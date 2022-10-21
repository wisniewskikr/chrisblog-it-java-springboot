package com.example.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.primitives.Ints;

public class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		
		int [] array = {45,12,85,32,89,39,69,44,42,1,6,8};
		
//		array = main.sortArrayIntAsc(array);
//		array = main.sortArrayIntDesc(array);
//		array = main.sortArrayIntAscStream(array);
		array = main.sortArrayIntDescStream(array);
//		array = main.sortArrayIntAscUtils(array);
//		array = main.sortArrayIntDescUtils(array);
//		array = main.sortArrayIntAscGuava(array);
//		array = main.sortArrayIntDescGuava(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}		  

	}
	
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
	
	public int[] sortArrayIntAscStream(int[] array) {
		return Arrays.stream(array).sorted().toArray();
	}
	
	public int[] sortArrayIntDescStream(int[] array) {
		return Arrays.stream(array).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
	}
	
	public int[] sortArrayIntAscUtils(int[] array) {
		Arrays.sort(array);
		return array;
	}
	
	public int[] sortArrayIntDescUtils(int[] array) {
		Arrays.sort(array);
		ArrayUtils.reverse(array);
		return array;
	}	
	
	public int[] sortArrayIntAscGuava(int[] array) {
		Collections.sort(Ints.asList(array));
		return array;
	}
	
	public int[] sortArrayIntDescGuava(int[] array) {
		Collections.sort(Ints.asList(array));
		Collections.reverse(Ints.asList(array));
		return array;
	}

}
