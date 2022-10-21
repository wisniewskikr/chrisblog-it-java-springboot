package com.example.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.lang3.SerializationUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {

	public static void main(String[] args) {
	
		Main main = new Main();
		
		User[] array = {new User(45),new User(12),new User(85),new User(32),new User(89),new User(39),new User(69),new User(44),new User(42),new User(1),new User(6),new User(8)};
		List<User> list = Arrays.asList(array);
		List<User> copyList = null;
		
		// DEEP COPY
		copyList = main.getListCopyByLoop(list);
//		copyList = main.getListCopyByStream(list);
//		copyList = main.getListCopyByJson(list);
//		copyList = main.getListCopyBySerialization(list);
//		copyList = main.getListCopyBySerializationUtils(list);
		
		// SHALLOW COPY
//		copyList = main.getListShallowCopyByLoop(list);
//		copyList = main.getListShallowCopyByStream(list);
//		copyList = main.getListShallowCopyByCollections(list);
//		copyList = main.getListShallowCopyByConstructor(list);
	
		System.out.println("List: " + list);	
		System.out.println("Copy List: " + copyList);	
		main.updateList(copyList);
		System.out.println("List after update Copy List: " + list);
		System.out.println("Copy List after update: " + copyList);	

	}
	
	public List<User> getListCopyByLoop(List<User> list) {
		
		List<User> copyList = new ArrayList<User>();
		
		for (User user : list) {
			copyList.add(new User(user.getAge()));
		}
		
		return copyList;
		
	}	
	
	public List<User> getListCopyByStream(List<User> list) {	
		return list.stream().map(p -> new User(p.getAge())).collect(Collectors.toList());
	}
	
	public List<User> getListCopyByJson(List<User> list) {
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		Type type = TypeToken.getParameterized(List.class, User.class).getType();
		return gson.fromJson(json, type);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getListCopyBySerialization(List<User> list) {		
		serialize(list);
		return (List<User>)deserialize(); 
	}
	
	public List<User> getListCopyBySerializationUtils(List<User> list) {
	    return SerializationUtils.clone(new ArrayList<>(list));
	}
	
	// ***** SHALLOW COPY ***** //
	
	public List<User> getListShallowCopyByLoop(List<User> list) {
		
		List<User> copyList = new ArrayList<User>();
		
		for (User user : list) {
			copyList.add(user);
		}
		
		return copyList;
		
	}
	
	public List<User> getListShallowCopyByStream(List<User> list) {	
		return list.stream().collect(Collectors.toList());
	}
	
	public List<User> getListShallowCopyByCollections(List<User> list) {	
		
		// It's the only way to initialize size()
		List<User> copyList = Arrays.asList(new User[list.size()]);
		Collections.copy(copyList, list);
		return copyList;
		
	}
	
	public List<User> getListShallowCopyByConstructor(List<User> list) {	
		return new ArrayList<User>(list);
	}
	
	// ***** HELP METHODS ***** //
	
	public void updateList(List<User> list) {
		
		for (User user : list) {
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

