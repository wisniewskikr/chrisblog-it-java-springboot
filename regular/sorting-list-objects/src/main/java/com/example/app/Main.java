package com.example.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		
		User[] array = {new User(45),new User(12),new User(85),new User(32),new User(89),new User(39),new User(69),new User(44),new User(42),new User(1),new User(6),new User(8)};
		List<User> list = Arrays.asList(array);
		
//		list = main.sortListUsersAsc(list);
//		list = main.sortListUsersDesc(list);
//		list = main.sortListUsersAscStream(list);
//		list = main.sortListUsersDescStream(list);
//		list = main.sortListUsersAscComparator(list);
//		list = main.sortListUsersDescComparator(list);
//		list = main.sortListUsersAscComparatorCustom(list);
//		list = main.sortListUsersDescComparatorCustom(list);
//		list = main.sortListUsersAscSort(list);
		list = main.sortListUsersDescSort(list);
		
		for (User user : list) {
			System.out.println(user);
		}

	}
	
	public List<User> sortListUsersAsc(List<User> list) {
		
		User temp;
		
		for (int i = 1; i < list.size(); i++) {
			
			for (int j = i; j > 0; j--) {
				if (list.get(j).getAge() < list.get(j - 1).getAge()) {
					temp = list.get(j);
					list.set(j, list.get(j - 1));
					list.set(j - 1, temp);			
				}
			}
			
		}
		
		return list;
		
	}
	
	public List<User> sortListUsersDesc(List<User> list) {
		
		User temp;
		
		for (int i = 1; i < list.size(); i++) {
			
			for (int j = i; j > 0; j--) {
				if (list.get(j).getAge() > list.get(j - 1).getAge()) {
					temp = list.get(j);
					list.set(j, list.get(j - 1));
					list.set(j - 1, temp);			
				}
			}
			
		}
		
		return list;
		
	}
	
	public List<User> sortListUsersAscStream(List<User> list) {
		return list.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
	}
	
	public List<User> sortListUsersDescStream(List<User> list) {
		return list.stream().sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.toList());
	}

	public List<User> sortListUsersAscComparator(List<User> list) {
		Collections.sort(list, Comparator.comparing(User::getAge));
		return list;
	}
	
	public List<User> sortListUsersDescComparator(List<User> list) {
		Collections.sort(list, Comparator.comparing(User::getAge).reversed());
		return list;
	}
	
	public List<User> sortListUsersAscComparatorCustom(List<User> list) {
		Collections.sort(list, new CustomComparatorAsc());
		return list;
	}
	
	public List<User> sortListUsersDescComparatorCustom(List<User> list) {
		Collections.sort(list, new CustomComparatorDesc());
		return list;
	}
	
	public List<User> sortListUsersAscSort(List<User> list) {
		list.sort(Comparator.comparing(User::getAge));
		return list;
	}
	
	public List<User> sortListUsersDescSort(List<User> list) {
		list.sort(Comparator.comparing(User::getAge).reversed());
		return list;
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
