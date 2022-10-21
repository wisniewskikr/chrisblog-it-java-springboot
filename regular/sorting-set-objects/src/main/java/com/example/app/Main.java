package com.example.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		
		User[] array = {new User(45),new User(12),new User(85),new User(32),new User(89),new User(39),new User(69),new User(44),new User(42),new User(1),new User(6),new User(8)};
		Set<User> set = new HashSet<>(Arrays.asList(array));
		
//		set = main.sortSetUsersAsc(set);
//		set = main.sortSetUsersDesc(set);
//		set = main.sortSetUsersAscStream(set);
//		set = main.sortSetUsersDescStream(set);
//		set = main.sortUsersAscTeeSet(set);
		set = main.sortUsersDescTeeSet(set);
		
		for (User user : set) {
			System.out.println(user);
		}

	}
	
	public Set<User> sortSetUsersAsc(Set<User> set) {
		
		User temp;
		List<User> list = new ArrayList<User>();
		int i = 0;
		
		for (User user : set) {
			
			if (i == 0) {
				list.add(user);
				i++;
				continue;
			} 
			list.add(user);
						
			for (int j = i; j > 0; j--) {
				if (list.get(j).getAge() < list.get(j - 1).getAge()) {
					temp = list.get(j);
					list.set(j, list.get(j - 1));
					list.set(j - 1, temp);			
				}
			}
			
			i++;
			
		}
		
		return new LinkedHashSet<User>(list);
		
	}
	
	public Set<User> sortSetUsersDesc(Set<User> set) {
		
		User temp;
		List<User> list = new ArrayList<User>();
		int i = 0;
		
		for (User user : set) {
			
			if (i == 0) {
				list.add(user);
				i++;
				continue;
			} 
			list.add(user);
						
			for (int j = i; j > 0; j--) {
				if (list.get(j).getAge() > list.get(j - 1).getAge()) {
					temp = list.get(j);
					list.set(j, list.get(j - 1));
					list.set(j - 1, temp);			
				}
			}
			
			i++;
			
		}
		
		return new LinkedHashSet<User>(list);
		
	}
	
	public Set<User> sortSetUsersAscStream(Set<User> set) {		
		return set.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toCollection(LinkedHashSet::new));
	}
	
	public Set<User> sortSetUsersDescStream(Set<User> set) {		
		return set.stream().sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.toCollection(LinkedHashSet::new));
	}
	
	public Set<User> sortUsersAscTeeSet(Set<User> set) {		
		Set<User> newSet = new TreeSet<User>(new CustomComparatorAsc());		
		newSet.addAll(set);
		return newSet;		
	}
	
	public Set<User> sortUsersDescTeeSet(Set<User> set) {		
		Set<User> newSet = new TreeSet<User>(new CustomComparatorDesc());		
		newSet.addAll(set);
		return newSet;		
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
