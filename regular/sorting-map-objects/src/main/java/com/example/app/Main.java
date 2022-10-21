package com.example.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		
		Map<Age, User> map = Stream.of(new Object[][] { 
		     { new Age(24), new User("John") }, 
		     { new Age(16), new User("Mary") },
		     { new Age(4), new User("Beth") }, 
		     { new Age(86), new User("Susan") }, 
		     { new Age(41), new User("Isabel") }, 
		     { new Age(52), new User("Mark") }, 
		 }).collect(Collectors.toMap(data -> (Age) data[0], data -> (User) data[1]));
		
		map = main.sortMapUsersAsc(map);
//		map = main.sortMapUsersDesc(map);
//		map = main.sorMapUsersAscStream(map);
//		map = main.sortMapUsersDescStream(map);		
//		map = main.sortMapUsersAscTreeMap(map);
//		map = main.sortMapUsersDescTreeMap(map);
//		map = main.sortByValueAscLinkedHashMap(map);
//		map = main.sortByValueDescLinkedHashMap(map);
		// sortByValueAscTreeMap and sortByValueDescTreeMap can not be implemented
		// because TreeMap automatically sorts by key.
		
		for (Age age : map.keySet()) {
			System.out.println(age + ":" + map.get(age));
		}

	}
	
	public Map<Age, User> sortMapUsersAsc(Map<Age, User> map) {
		
		Age temp;
		List<Age> list = new ArrayList<Age>();
		int i = 0;
		
		for (Age age : map.keySet()) {
			
			if (i == 0) {
				list.add(age);
				i++;
				continue;
			} 
			list.add(age);
						
			for (int j = i; j > 0; j--) {
				if (list.get(j).getAge() < list.get(j - 1).getAge()) {
					temp = list.get(j);
					list.set(j, list.get(j - 1));
					list.set(j - 1, temp);			
				}
			}
			
			i++;
			
		}
		
		Map<Age, User> result = new LinkedHashMap<>();
		for (Age age : list) {
			User user = map.get(age);
			result.put(age, user);
		}
		
		return result;
		
	}
	
	public Map<Age, User> sortMapUsersDesc(Map<Age, User> map) {
		
		Age temp;
		List<Age> list = new ArrayList<Age>();
		int i = 0;
		
		for (Age age : map.keySet()) {
			
			if (i == 0) {
				list.add(age);
				i++;
				continue;
			} 
			list.add(age);
						
			for (int j = i; j > 0; j--) {
				if (list.get(j).getAge() > list.get(j - 1).getAge()) {
					temp = list.get(j);
					list.set(j, list.get(j - 1));
					list.set(j - 1, temp);			
				}
			}
			
			i++;
			
		}
		
		Map<Age, User> result = new LinkedHashMap<>();
		for (Age age : list) {
			User user = map.get(age);
			result.put(age, user);
		}
		
		return result;
		
	}
	
	public Map<Age, User> sorMapUsersAscStream(Map<Age, User> map) {
		
		return map.entrySet()
		  .stream()
		  .sorted(Map.Entry.<Age, User>comparingByKey(Comparator.comparing(Age::getAge)))
		  .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                  (e1, e2) -> e1, LinkedHashMap<Age, User>::new));
		
	}
	
	public Map<Age, User> sortMapUsersDescStream(Map<Age, User> map) {
		
		return map.entrySet()
		  .stream()
		  .sorted(Map.Entry.<Age, User>comparingByKey(Comparator.comparing(Age::getAge).reversed()))
		  .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                  (e1, e2) -> e1, LinkedHashMap<Age, User>::new));
		
	}	
	
	public Map<Age, User> sortMapUsersAscTreeMap(Map<Age, User> map) {
		
		TreeMap<Age, User> treeMap = new TreeMap<>(new CustomComparatorAsc());		
		treeMap.putAll(map);
		return treeMap;		
		
	}
	
	public Map<Age, User> sortMapUsersDescTreeMap(Map<Age, User> map) {
		
		TreeMap<Age, User> treeMap = new TreeMap<>(new CustomComparatorDesc());		
		treeMap.putAll(map);
		return treeMap;		
		
	}
	
	public Map<Age, User> sortByValueAscLinkedHashMap(Map<Age, User> map) {
		
		return map.entrySet()
		  .stream()
		  .sorted(Map.Entry.<Age, User>comparingByValue(Comparator.comparing(User::getName)))
		  .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                  (e1, e2) -> e1, LinkedHashMap<Age, User>::new));
		
	}
	
	public Map<Age, User> sortByValueDescLinkedHashMap(Map<Age, User> map) {
		
		return map.entrySet()
		  .stream()
		  .sorted(Map.Entry.<Age, User>comparingByValue(Comparator.comparing(User::getName).reversed()))
		  .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                  (e1, e2) -> e1, LinkedHashMap<Age, User>::new));
		
	}
	
}

class CustomComparatorAsc implements Comparator<Age> {
	
	@Override
	public int compare(Age a1, Age a2)  {
		return a1.getAge() - a2.getAge();
	}
	
}

class CustomComparatorDesc implements Comparator<Age> {
	
	@Override
	public int compare(Age a1, Age a2)  {
		return a2.getAge() - a1.getAge();
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
