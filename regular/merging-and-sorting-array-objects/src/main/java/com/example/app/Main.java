package com.example.app;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		
		User[] sortedArray1Asc = {new User(12),new User(45),new User(85)};
		User[] sortedArray2Asc = {new User(9),new User(33),new User(76)};
		User[] sortedArray1Desc = {new User(85),new User(45),new User(12)};
		User[] sortedArray2Desc = {new User(76),new User(33),new User(9)};
		User[] array1 = {new User(45),new User(12),new User(85),new User(32),new User(89),new User(39),new User(69)};
		User[] array2 = {new User(44),new User(42),new User(1),new User(6),new User(8)};
		User[] mergedArray = null;	
		
		mergedArray = main.mergeSortedArraysUserAsc(sortedArray1Asc, sortedArray2Asc);
//		mergedArray = main.mergeSortedArraysUserDesc(sortedArray1Desc, sortedArray2Desc);
//		mergedArray = main.mergeAndSortArraysUserAsc(array1, array2);
//		mergedArray = main.mergeAndSortArraysUserDesc(array1, array2);
		
		for (int i = 0; i < mergedArray.length; i++) {
			System.out.println(mergedArray[i]);
		}		  

	}
	
	public User[] mergeSortedArraysUserAsc(User[] sortedArray1Asc, User[] sortedArray2Asc) {
		
		User[] answer = new User[sortedArray1Asc.length + sortedArray2Asc.length];
	    int i = 0, j = 0, k = 0;

	    while (i < sortedArray1Asc.length && j < sortedArray2Asc.length)  
	       answer[k++] = sortedArray1Asc[i].getAge() < sortedArray2Asc[j].getAge() ? sortedArray1Asc[i++] :  sortedArray2Asc[j++];

	    while (i < sortedArray1Asc.length)  
	        answer[k++] = sortedArray1Asc[i++];

	    while (j < sortedArray2Asc.length)    
	        answer[k++] = sortedArray2Asc[j++];

	    return answer;
		
	}
	
	public User[] mergeSortedArraysUserDesc(User[] sortedArray1Desc, User[] sortedArray2Desc) {
		
		User[] answer = new User[sortedArray1Desc.length + sortedArray2Desc.length];
	    int i = 0, j = 0, k = 0;

	    while (i < sortedArray1Desc.length && j < sortedArray2Desc.length)  
	       answer[k++] = sortedArray1Desc[i].getAge() > sortedArray2Desc[j].getAge() ? sortedArray1Desc[i++] :  sortedArray2Desc[j++];

	    while (i < sortedArray1Desc.length)  
	        answer[k++] = sortedArray1Desc[i++];

	    while (j < sortedArray2Desc.length)    
	        answer[k++] = sortedArray2Desc[j++];

	    return answer;
		
	}
	
	public User[] mergeAndSortArraysUserAsc(User[] array1, User[] array2) {
		
		User[] sortedArray1Asc = sortArrayUsersAsc(array1);
		User[] sortedArray2Asc = sortArrayUsersAsc(array2);
		return mergeSortedArraysUserAsc(sortedArray1Asc, sortedArray2Asc);
		
	}
	
	public User[] mergeAndSortArraysUserDesc(User[] array1, User[] array2) {
		
		User[] sortedArray1Desc = sortArrayUsersDesc(array1);
		User[] sortedArray2Desc = sortArrayUsersDesc(array2);
		return mergeSortedArraysUserDesc(sortedArray1Desc, sortedArray2Desc);
		
	}
	
	// ***** HELP METHODS ***** //
	
	public User[] sortArrayUsersAsc(User[] array) {
		
		User temp;
		
		for (int i = 1; i < array.length; i++) {
			
			for (int j = i; j > 0; j--) {
				if (array[j].getAge() < array [j - 1].getAge()) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
			
		}
		
		return array;
		
	}
	
	public User[] sortArrayUsersDesc(User[] array) {
		
		User temp;
		
		for (int i = 1; i < array.length; i++) {
			
			for (int j = i; j > 0; j--) {
				if (array[j].getAge() > array [j - 1].getAge()) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
			
		}
		
		return array;
		
	}
	
	

}

class User {
	
	private int age;	

	public User(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return String.valueOf(age);
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}			
	
}
