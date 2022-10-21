package com.example.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.SerializationUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {

	public static void main(String[] args) {
	
		Main main = new Main();
		
		User[] array = {new User(45),new User(12),new User(85),new User(32),new User(89),new User(39),new User(69),new User(44),new User(42),new User(1),new User(6),new User(8)};
		Set<User> set = new LinkedHashSet<User>(Arrays.asList(array));
		Set<User> copySet = null;
		
		// DEEP COPY
		copySet = main.getSetCopyByLoop(set);
//		copySet = main.getSetCopyByStream(set);
//		copySet = main.getSetCopyByJson(set);
//		copySet = main.getSetCopyBySerialization(set);
//		copySet = main.getSetCopyBySerializationUtils(set);
		
		// SHALLOW COPY
//		copySet = main.getSetShallowCopyByLoop(set);
//		copySet = main.getSetShallowCopyByStream(set);
//		copySet = main.getSetShallowCopyByConstructor(set);
//	
		System.out.println("Set: " + set);	
		System.out.println("Copy Set: " + copySet);	
		main.updateList(copySet);
		System.out.println("Set after update Copy Set: " + set);
		System.out.println("Copy Set after update: " + copySet);	

	}
	
	public Set<User> getSetCopyByLoop(Set<User> set) {
		
		Set<User> copySet = new LinkedHashSet<User>();
		
		for (User user : set) {
			copySet.add(new User(user.getAge()));
		}
		
		return copySet;
		
	}	
	
	public Set<User> getSetCopyByStream(Set<User> set) {	
		return set.stream().map(p -> new User(p.getAge())).collect(Collectors.toCollection(LinkedHashSet::new));
	}
	
	public Set<User> getSetCopyByJson(Set<User> set) {
		
		Gson gson = new Gson();
		String json = gson.toJson(set);
		Type type = TypeToken.getParameterized(Set.class, User.class).getType();
		return gson.fromJson(json, type);
		
	}
	
	@SuppressWarnings("unchecked")
	public Set<User> getSetCopyBySerialization(Set<User> set) {		
		serialize(set);
		return (Set<User>)deserialize(); 
	}
	
	public Set<User> getSetCopyBySerializationUtils(Set<User> set) {
	    return SerializationUtils.clone(new HashSet<>(set));
	}
	
	// ***** SHALLOW COPY ***** //
	
	public Set<User> getSetShallowCopyByLoop(Set<User> set) {
		
		Set<User> copySet = new LinkedHashSet<User>();
		
		for (User user : set) {
			copySet.add(user);
		}
		
		return copySet;
		
	}
	
	public Set<User> getSetShallowCopyByStream(Set<User> set) {	
		return set.stream().collect(Collectors.toCollection(LinkedHashSet::new));
	}
	
	public Set<User> getSetShallowCopyByConstructor(Set<User> set) {	
		return new LinkedHashSet<User>(set);
	}
	
	// ***** HELP METHODS ***** //
	
	public void updateList(Set<User> set) {
		
		for (User user : set) {
			user.setAge(new Random().nextInt(100));
		}
		
	}
	
	public void serialize(Object object) {
		
		try {
	      FileOutputStream out = new FileOutputStream("serialization.out");
	      ObjectOutputStream oos = new ObjectOutputStream(out);
	      oos.writeObject(object);
	      oos.flush();
	      oos.close();
	      out.close();
	    } catch (Exception e) {
	      System.out.println("Problem serializing: " + e);
	    }
		
	}
	
	public Object deserialize() {
		
		Object result = null;
		
		try {
	      FileInputStream in = new FileInputStream("serialization.out");
	      ObjectInputStream ois = new ObjectInputStream(in);
	      result = ois.readObject();
	      ois.close();
	      in.close();
	    } catch (Exception e) {
	      System.out.println("Problem serializing: " + e);
	    }
		
		return result;
		
	}

}

class User implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	private int age;	

	public User(int age) {
		this.age = age;
	}	

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new User(age);
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

