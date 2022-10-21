package com.example.app;


public class Main {

	public static void main(String[] args) {		
		
		int arrayWithEqbmIndex[] = {9, 3, 7, 6, 8, 1, 10};
		int arrayWithoutEqbmIndex[] = {9, 4, 7, 6, 8, 1, 10};
		int eqbmIndex;
		
		eqbmIndex = eqbmIndexIncremental(arrayWithEqbmIndex);
//		eqbmIndex = eqbmIndexIncremental(arrayWithoutEqbmIndex);
		
//		eqbmIndex = eqbmIndexIterative(arrayWithEqbmIndex);
//		eqbmIndex = eqbmIndexIterative(arrayWithoutEqbmIndex);
		
//		eqbmIndex = eqbmIndexBruteForce(arrayWithEqbmIndex);
//		eqbmIndex = eqbmIndexBruteForce(arrayWithoutEqbmIndex);
				
		System.out.print("Equilibrium Index is: " + eqbmIndex);  
		

	}
	
	static int eqbmIndexIncremental(int array[]) {
		
		int rsum = 0;
		int lsum = 0;

		for (int i = 0; i < array.length; ++i)
			rsum = rsum + array[i];
		
		for (int i = 0; i < array.length; ++i) {
			
			rsum = rsum - array[i];
			
			if (lsum == rsum)
				return i;
			
			lsum = lsum + array[i];
			
		}
		
		return -1;
	} 
	
	static int eqbmIndexIterative(int array[]) {

		int[] prefix = new int[array.length];
		int i;		
		int lsum, rsum;

		for (i = 0; i < array.length; i++) {
			if (i == 0)
				prefix[i] = array[i];
			else
				prefix[i] = array[i] + prefix[i - 1];
		}		
		rsum = prefix[array.length - 1];
		
		for (i = 0; i < array.length - 1; i++) {
			
			rsum = rsum - array[i];
			lsum = prefix[i + 1];
			
			if (rsum == lsum)
				return i + 1;
			
		}
		
		return -1;
	}
	
	static int eqbmIndexBruteForce(int array[]) {
		
		int i, j;		
		int lsum, rsum;
		
		for (i = 0; i < array.length; ++i) {
			
			lsum = 0;			
			for (j = 0; j < i; j++)
				lsum = lsum + array[j];
			
			rsum = 0;			
			for (j = i + 1; j < array.length; j++)
				rsum = rsum + array[j];
			
			if (lsum == rsum)
				return i;
			
		}
		
		return -1;
		
	} 
	
}