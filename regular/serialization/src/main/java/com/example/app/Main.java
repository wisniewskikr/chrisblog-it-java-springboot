package com.example.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.SerializationUtils;


public class Main {

	public static void main(String[] args) {
	
		Main main = new Main();		
		
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
		Item item = new Item(user, age, primitivesArray, objectsArray, list, set, map);
		Item itemAfterSerialization = null;
		
		itemAfterSerialization = main.serializationCustom(item);
//		itemAfterSerialization = main.serializationUtils(item);
		
		System.out.println("Item: " + item);	
		System.out.println("Item After Serialization: " + itemAfterSerialization);	
		main.updateItem(itemAfterSerialization);
		System.out.println("Item after Item After Serialization shuffle: " + item);
		System.out.println("Item After Serialization after shuffle: " + itemAfterSerialization);	

	}
	
	// ***** MAIN METHODS ***** //
	
	public Item serializationCustom(Item item) {
		serialize(item, "serialize.out");
		return (Item)deserialize("serialize.out");
	}
	
	public Item serializationUtils(Item item) {
		return SerializationUtils.clone(item);
	}
	
	// ***** HELP METHODS ***** //
	
	public Item updateItem(Item item) {
		item.getUser().setName("Diana");
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
			array[i] = new Random().nextInt(100);
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
			entry.getKey().setAge(new Random().nextInt());
			entry.getValue().setName("Name");
		}
		
	}
	
	public String getRandomString() {
	    byte[] array = new byte[7]; // length is bounded by 7
	    new Random().nextBytes(array);
	    return new String(array, Charset.forName("UTF-8"));
	}
	
	public void serialize(Object object, String serializationFile) {

		FileOutputStream out = null;
		ObjectOutputStream oos = null;
		try {
			out = new FileOutputStream(serializationFile);
			oos = new ObjectOutputStream(out);
			oos.writeObject(object);
		} catch (Exception e) {
			System.out.println("Problem serializing: " + e);
		} finally {
			try {
				oos.flush();
				oos.close();
				out.close();
			} catch (Exception e) {
				System.out.println("Problem serializing finally: " + e);
			}
		}

	}
	
	public Object deserialize(String serializationFile) {

		Object result = null;
		ObjectInputStream ois = null;
		FileInputStream in = null;
		try {
			in = new FileInputStream(serializationFile);
			ois = new ObjectInputStream(in);
			result = ois.readObject();
		} catch (Exception e) {
			System.out.println("Problem serializing: " + e);
		} finally {
			try {
				ois.close();
				in.close();
			} catch (Exception e) {
				System.out.println("Problem serializing finally: " + e);
			}
		}

		return result;

	}

}

class Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private User user;
	private Age age;
	private int[] primitivesArray;
	private User[] objectsArray;
	private List<User> list;
	private Set<User> set;
	Map<Age, User> map;
	
	
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

class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
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

class Age implements Serializable {
	
	private static final long serialVersionUID = 2L;
	private Integer age;	

	public Age(Integer age) {
		this.age = age;
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