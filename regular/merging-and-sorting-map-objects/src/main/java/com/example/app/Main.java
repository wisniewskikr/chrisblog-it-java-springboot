package com.example.app;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		
		Map<Age, User> map1 = Stream.of(new Object[][] { 
		     { new Age(24), new User("John") }, 
		     { new Age(16), new User("Mary") },
		     { new Age(4), new User("Beth") }		      
		 }).collect(Collectors.toMap(data -> (Age) data[0], data -> (User) data[1]));
		
		Map<Age, User> map2 = Stream.of(new Object[][] {		    
		     { new Age(86), new User("Susan") }, 
		     { new Age(41), new User("Isabel") }, 
		     { new Age(52), new User("Mark") }, 
		 }).collect(Collectors.toMap(data -> (Age) data[0], data -> (User) data[1]));
		
		Map<Age, User> sortedMap = null;
		
//		sortedMap = main.mergeAndSortByKeyAscLinkedHashMap(map1, map2);
		sortedMap = main.mergeAndSortByKeyDescLinkedHashMap(map1, map2);
		
		for (Age age : sortedMap.keySet()) {
			System.out.println(age + ":" + sortedMap.get(age));
		}

	}
	
	public Map<Age, User> mergeAndSortByKeyAscLinkedHashMap(Map<Age, User> map1, Map<Age, User> map2) {
		
		return Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
				  .sorted(Map.Entry.<Age, User>comparingByKey(Comparator.comparing(Age::getAge)))
				  .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
		                  (e1, e2) -> e1, LinkedHashMap<Age, User>::new));
		
	}
	
	public Map<Age, User> mergeAndSortByKeyDescLinkedHashMap(Map<Age, User> map1, Map<Age, User> map2) {
		
		return Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
				  .sorted(Map.Entry.<Age, User>comparingByKey(Comparator.comparing(Age::getAge).reversed()))
				  .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
		                  (e1, e2) -> e1, LinkedHashMap<Age, User>::new));
		
	}
	
}

class Age {
	
	private int age;	

	public Age(int age) {
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

class User {
	
	private String name;
	
	public User(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
}
