package com.example.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.SerializationUtils;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		
		User[] array = {new User(45),new User(12),new User(85),new User(32),new User(89),new User(39),new User(69),new User(44),new User(42),new User(1),new User(6),new User(8)};
		User[] arrayCopy = null;
		
		// DEEP COPY
		arrayCopy = main.getArrayCopyByLoop(array);
//		arrayCopy = main.getArrayCopyByStream(array);
//		arrayCopy = main.getArrayCopyByJson(array);
		arrayCopy = main.getArrayCopyBySerialization(array);
//		arrayCopy = main.getArrayCopyBySerializationUtils(array);
				
		// SHALLOW COPY
//		arrayCopy = main.getArrayShallowCopyByLoop(array);
//		arrayCopy = main.getArrayShallowCopyByStream(array);
//		arrayCopy = main.getArrayShallowCopyByArrays(array);
		
		System.out.println("Array: " + Arrays.toString(array));	
		System.out.println("Array Copy: " + Arrays.toString(arrayCopy));	
		main.shuffleArray(arrayCopy);
		System.out.println("Array after Array Copy shuffle: " + Arrays.toString(array));
		System.out.println("Array Copy after shuffle: " + Arrays.toString(arrayCopy));	

	}
	
	public User[] getArrayCopyByLoop(User[] array) {
		
		User[] arrayCopy = new User[array.length];
		
		for (int i = 0; i < array.length; i++) {
			arrayCopy[i] = new User(array[i].getAge());
		}
		
		return arrayCopy;
		
	}
	
	public User[] getArrayCopyByStream(User[] array) {	
		return Arrays.stream(array).map(p -> new User(p.getAge())).toArray(User[]::new);
	}
	
	public User[] getArrayCopyByJson(User[] array) {
		
		Gson gson = new Gson();
		String json = gson.toJson(array);
		return gson.fromJson(json, User[].class);
		
	}
	
	public User[] getArrayCopyBySerialization(User[] array) {		
		serialize(array);
		return (User[])deserialize();
	}
	
	public User[] getArrayCopyBySerializationUtils(User[] array) {		
		return SerializationUtils.clone(array);		
	}
	
	// ***** SHALLOW COPY ***** //
	
	public User[] getArrayShallowCopyByLoop(User[] array) {
		
		User[] arrayCopy = new User[array.length];
		
		for (int i = 0; i < array.length; i++) {
			arrayCopy[i] = array[i];
		}
		
		return arrayCopy;
		
	}
	
	public User[] getArrayShallowCopyByStream(User[] array) {	
		return Arrays.stream(array).toArray(User[]::new);
	}
	
	public User[] getArrayShallowCopyByArrays(User[] array) {		
		return Arrays.copyOf(array, array.length);		
	}
	
	// ***** HELP METHODS ***** //
	
	public void shuffleArray(User[] array) {
		
		for (int i = 0; i < array.length; i++) {
			array[i].setAge(new Random().nextInt(100));
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

class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
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

