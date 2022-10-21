package com.example.app;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		
		User[] array = {new User(45),new User(12),new User(85),new User(32),new User(89),new User(39),new User(69),new User(44),new User(42),new User(1),new User(6),new User(8)};
		
//		array = main.sortArrayUsersAsc(array);
//		array = main.sortArrayUsersDesc(array);
//		array = main.sortArrayUsersAscStream(array);
//		array = main.sortArrayUsersDescStream(array);
//		array = main.sortArrayUsersAscComparator(array);
//		array = main.sortArrayUsersDescComparator(array);
//		array = main.sortArrayUsersAscComparatorCustom(array);
		array = main.sortArrayUsersDescComparatorCustom(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}		  

	}
	
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
	
	public User[] sortArrayUsersAscStream(User[] array) {
		return Arrays.stream(array).sorted(Comparator.comparing(User::getAge)).toArray(User[]::new);
	}
	
	public User[] sortArrayUsersDescStream(User[] array) {
		return Arrays.stream(array).sorted( Comparator.comparing(User::getAge).reversed()).toArray(User[]::new);
	}
	
	public User[] sortArrayUsersAscComparator(User[] array) {
		Arrays.sort(array, Comparator.comparing(User::getAge));
		return array;
	}
	
	public User[] sortArrayUsersDescComparator(User[] array) {
		Arrays.sort(array, Comparator.comparing(User::getAge).reversed());
		return array;
	}
	
	public User[] sortArrayUsersAscComparatorCustom(User[] array) {		
		Arrays.sort(array, new CustomComparatorAsc());		
		return array;		
	}
	
	public User[] sortArrayUsersDescComparatorCustom(User[] array) {		
		Arrays.sort(array, new CustomComparatorDesc());		
		return array;		
	}

}

class CustomComparatorAsc implements Comparator<User> {
	
	@Override
	public int compare(User u1, User u2)  {
		return u1.getAge() - u2.getAge();
	}
	
}

class CustomComparatorDesc implements Comparator<User> {
	
	@Override
	public int compare(User u1, User u2)  {
		return u2.getAge() - u1.getAge();
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
