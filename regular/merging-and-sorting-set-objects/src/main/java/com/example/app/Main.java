package com.example.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		
		User[] array1 = {new User(45),new User(12),new User(85),new User(32),new User(89)};
		User[] array2 = {new User(39),new User(69),new User(44),new User(42),new User(1),new User(6),new User(8)};
		Set<User> set1 = new HashSet<>(Arrays.asList(array1));
		Set<User> set2 = new HashSet<>(Arrays.asList(array2));
		Set<User> sortedSet = null; 
		
//		sortedSet = main.mergeAndSortUserAscLikedHashSet(set1, set2);
		sortedSet = main.mergeAndSortUserDescLikedHashSet(set1, set2);
		
		for (User user : sortedSet) {
			System.out.println(user);
		}

	}
	
	public Set<User> mergeAndSortUserAscLikedHashSet(Set<User> set1, Set<User> set2) {
		
		List<User> list1 = new ArrayList<User>(set1);
		List<User> list2 = new ArrayList<User>(set2);
		list1.addAll(list2);
		Collections.sort(list1, Comparator.comparing(User::getAge));
		return new LinkedHashSet<User>(list1);
		
	}
	
	public Set<User> mergeAndSortUserDescLikedHashSet(Set<User> set1, Set<User> set2) {
		
		List<User> list1 = new ArrayList<User>(set1);
		List<User> list2 = new ArrayList<User>(set2);
		list1.addAll(list2);
		Collections.sort(list1, Comparator.comparing(User::getAge).reversed());
		return new LinkedHashSet<User>(list1);
		
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
