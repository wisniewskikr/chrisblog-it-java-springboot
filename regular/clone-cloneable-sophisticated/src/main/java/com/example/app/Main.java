package com.example.app;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
	
		Main main = new Main();		
		
		Item oldItem = main.createItem();
		Item newItem = (Item)oldItem.clone();
		
		main.shuffleAnddisplayResult(oldItem, newItem);

	}
	
	// ***** HELP METHODS ***** //
	
	public Item createItem() {
		
		User user = new User("John");
		Age age = new Age(40);
		int[] primitivesArray = {12,56,17};
		User[] objectsArray = {new User("John"), new User("Mike")};		
		List<User> list = Arrays.asList(new User[] {
				new User("Sam"), new User("Rocky")
		});
		Set<User> set = new LinkedHashSet<User>(Arrays.asList(new User[] {
				new User("Alice"), new User("Bob")
		}));
		Map<Age, User> map = Stream.of(new Object[][] { 
		     { new Age(24), new User("John") }, 
		     { new Age(16), new User("Mary") },
		     { new Age(4), new User("Beth") }		  
		 }).collect(Collectors.toMap(data -> (Age) data[0], data -> (User) data[1]));
		return new Item(user, age, primitivesArray, objectsArray, list, set, map);
		
	}
	
	public void shuffleAnddisplayResult(Item oldItem, Item newItem) {
		
		System.out.println("Old Item: " + oldItem);	
		System.out.println("New Item: " + newItem);	
		updateItem(newItem);
		System.out.println("Old Item after New Item shuffling: " + oldItem);
		System.out.println("New Item after New Item shuffling: " + newItem);	
		
	}
	
	public Item updateItem(Item item) {
		item.getUser().setName(getRandomString());
		item.getAge().setAge(13);
		shuffleArray(item.getPrimitivesArray());
		shuffleArray(item.getObjectsArray());
		updateList(item.getList());
		updateSet(item.getSet());
		updateMap(item.getMap());
		return item;
	}
	
	public void shuffleArray(int[] array) {
		
		for (int i = 0; i < array.length; i++) {
			array[i] = getRandomInt(1, 70);
		}
		
	}
	
	public void shuffleArray(User[] array) {
		
		for (int i = 0; i < array.length; i++) {
			array[i].setName(getRandomString());
		}
		
	}
	
	public void updateList(List<User> list) {
		
		for (User user : list) {
			user.setName(getRandomString());
		}
		
	}
	
	public void updateSet(Set<User> set) {
		
		for (User user : set) {
			user.setName(getRandomString());
		}
		
	}
	
	public void updateMap(Map<Age, User> map) {
		
		Set<Entry<Age, User>> entrySet = map.entrySet();
		for (Entry<Age, User> entry : entrySet) {
			entry.getKey().setAge(getRandomInt(1, 70));
			entry.getValue().setName(getRandomString());
		}
		
	}
	
	public String getRandomString() {

	    // create a string of all characters
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    // create random string builder
	    StringBuilder sb = new StringBuilder();

	    // create an object of Random class
	    Random random = new Random();

	    // specify length of random string
	    int length = 7;

	    for(int i = 0; i < length; i++) {

	      // generate random index number
	      int index = random.nextInt(alphabet.length());

	      // get character specified by index
	      // from the string
	      char randomChar = alphabet.charAt(index);

	      // append the character to string builder
	      sb.append(randomChar);
	    }

	    return sb.toString().toLowerCase();	    

	  }
	
	public int getRandomInt(int min, int max) {
	    Random random = new Random();
	    return random.nextInt(max - min) + min;
	}

}

class Item implements Cloneable {
	
	private User user;
	private Age age;
	private int[] primitivesArray;
	private User[] objectsArray;
	private List<User> list;
	private Set<User> set;
	private Map<Age, User> map;

	public Item(User user, Age age, int[] primitivesArray, User[] objectsArray, List<User> list, Set<User> set,
			Map<Age, User> map) {
		super();
		this.user = user;
		this.age = age;
		this.primitivesArray = primitivesArray;
		this.objectsArray = objectsArray;
		this.list = list;
		this.set = set;
		this.map = map;
	}
		
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Item item = new Item(
				(User)user.clone(), 
				(Age)age.clone(), 
				clonePrimitivesArray(primitivesArray), 
				cloneObjectsArray(objectsArray), 
				cloneList(list), 
				cloneSet(set), 
				cloneMap(map));
		
		
		
		return item;
	}
	
	private int[] clonePrimitivesArray(int[] primitivesArray) {		
		return Arrays.stream(primitivesArray).toArray();	
	}
	
	private User[] cloneObjectsArray(User[] objectsArray) {
		return Arrays.stream(objectsArray).map(e -> new User(e.getName())).toArray(User[]::new);
	}
	
	private List<User> cloneList(List<User> list) {
		return list.stream().map(e -> new User(e.getName())).collect(Collectors.toList());
	}
	
	private Set<User> cloneSet(Set<User> set) {
		return set.stream().map(e -> new User(e.getName())).collect(Collectors.toSet());
	}
	
	private Map<Age, User> cloneMap(Map<Age, User> map) {
		return map.entrySet().stream()
		    	.collect(Collectors.toMap(e -> new Age(e.getKey().getAge()), e -> new User(e.getValue().getName())));
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb
		.append("User: " + user)
		.append(", ")
		.append("Age: " + age)
		.append(", ")
		.append("Primitives Array: " + Arrays.toString(primitivesArray))
		.append(", ")
		.append("Objects Array: " + Arrays.toString(objectsArray))
		.append(", ")
		.append("List: " + list)
		.append(", ")
		.append("Set: " + set)
		.append(", ")
		.append("Map: " + map);
		return sb.toString();
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Age getAge() {
		return age;
	}
	public void setAge(Age age) {
		this.age = age;
	}
	
	public int[] getPrimitivesArray() {
		return primitivesArray;
	}
	public void setPrimitivesArray(int[] primitivesArray) {
		this.primitivesArray = primitivesArray;
	}
	
	public User[] getObjectsArray() {
		return objectsArray;
	}
	public void setObjectsArray(User[] objectsArray) {
		this.objectsArray = objectsArray;
	}
	
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	
	public Set<User> getSet() {
		return set;
	}
	public void setSet(Set<User> set) {
		this.set = set;
	}
	
	public Map<Age, User> getMap() {
		return map;
	}
	public void setMap(Map<Age, User> map) {
		this.map = map;
	}	
	
}

class User implements Cloneable {
	
	private String name;

	public User(String name) {
		this.name = name;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new User(name);
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

class Age implements Cloneable {
	
	private Integer age;

	public Age(Integer age) {
		this.age = age;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Age(age);
	}

	@Override
	public String toString() {
		return String.valueOf(age);
	}

	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}				
	
}