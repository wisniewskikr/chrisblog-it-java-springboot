package com.example.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		
		User[] array1 = {new User(45),new User(12),new User(85),new User(32),new User(89),new User(39)};
		User[] array2 = {new User(69),new User(44),new User(42),new User(1),new User(6),new User(8)};
		List<User> list1 = new ArrayList<User>(Arrays.asList(array1));
		List<User> list2 = new ArrayList<User>(Arrays.asList(array2));
		List<User> sortedList = null;
		
//		sortedList = main.mergeAndSortUsersAsc(list1, list2);
		sortedList = main.mergeAndSortUsersDesc(list1, list2);
		
		for (User user : sortedList) {
			System.out.println(user);
		}

	}
	
	public List<User> mergeAndSortUsersAsc(List<User> list1, List<User> list2) {
		list1.addAll(list2);
		Collections.sort(list1, Comparator.comparing(User::getAge));
		return list1;
	}
	
	public List<User> mergeAndSortUsersDesc(List<User> list1, List<User> list2) {
		list1.addAll(list2);
		Collections.sort(list1, Comparator.comparing(User::getAge).reversed());
		return list1;
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
