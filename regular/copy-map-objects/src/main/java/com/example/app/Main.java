package com.example.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.SerializationUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

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
		Map<Age, User> copyMap = null;
		
		// DEEP COPY
		copyMap = main.getSetCopyByLoop(map);
//		copyMap = main.getSetCopyByStream(map);
//		copyMap = main.getSetCopyByJson(map);
//		copyMap = main.getSetCopyBySerialization(map);
//		copyMap = main.getSetCopyBySerializationUtils(map);
		
		// SHALLOW COPY
//		copyMap = main.getSetShallowCopyByLoop(map);
//		copyMap = main.getSetShallowCopyByStream(map);
//		copyMap = main.getSetShallowCopyByConstructor(map);
	
		System.out.println("Map: " + map);	
		System.out.println("Copy Map: " + copyMap);	
		main.updateMap(copyMap);
		System.out.println("Map after update Copy Map: " + map);
		System.out.println("Copy Map after update: " + copyMap);	

	}
	
	public Map <Age, User> getSetCopyByLoop(Map<Age, User> map) {
		
		Map<Age, User> copyMap = new LinkedHashMap<Age, User>();
		
		Set<Entry<Age, User>> entrySet = map.entrySet();
		for (Entry<Age, User> entry : entrySet) {
			copyMap.put(new Age(entry.getKey().getAge()), new User(entry.getValue().getName()));
		}
		
		return copyMap;
		
	}	
	
	public Map<Age, User> getSetCopyByStream(Map<Age, User> map) {	
		return map.entrySet().stream()
		    	.collect(Collectors.toMap(e -> new Age(e.getKey().getAge()), e -> new User(e.getValue().getName())));
	}
	
	public Map<Age, User> getSetCopyByJson(Map<Age, User> map) {
		
		Gson gson = new Gson();
		String json = gson.toJson(map);		
		Type type = new TypeToken<Map<Age, User>>() {}.getType();
		gson = new GsonBuilder()
				  .registerTypeAdapter(type, new StringDateMapDeserializer())
				  .create();
		
		
		return gson.fromJson(json, type);
		
	}
	
	@SuppressWarnings("unchecked")
	public Map<Age, User> getSetCopyBySerialization(Map<Age, User> map) {
		serialize(map);
		return (Map<Age, User>)deserialize(); 
	}
	
	public Map<Age, User> getSetCopyBySerializationUtils(Map<Age, User> map) {
	    return SerializationUtils.clone(new HashMap<>(map));
	}
	
	// ***** SHALLOW COPY ***** //
	
	public Map<Age, User> getSetShallowCopyByLoop(Map<Age, User> map) {
		
		Map<Age, User> copyMap = new LinkedHashMap<Age, User>();
		
		Set<Entry<Age, User>> entrySet = map.entrySet();
		for (Entry<Age, User> entry : entrySet) {
			copyMap.put(entry.getKey(), entry.getValue());
		}
		
		return copyMap;
		
	}
	
	public Map<Age, User> getSetShallowCopyByStream(Map<Age, User> map) {	
		return map.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
	}
	
	public Map<Age, User> getSetShallowCopyByConstructor(Map<Age, User> set) {	
		return new LinkedHashMap<Age, User>(set);
	}
	
	// ***** HELP METHODS ***** //
	
	public void updateMap(Map<Age, User> map) {
		
		Set<Entry<Age, User>> entrySet = map.entrySet();
		for (Entry<Age, User> entry : entrySet) {
			entry.getKey().setAge(new Random().nextInt());
			entry.getValue().setName("Name");
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

class StringDateMapDeserializer implements JsonDeserializer<Map<Age, User>> {

    @Override
    public Map<Age, User> deserialize(JsonElement elem,
          Type type,
          JsonDeserializationContext jsonDeserializationContext) {
    	
        return elem.getAsJsonObject()
          .entrySet()
          .stream()
          .collect(
        		  Collectors.toMap(            		
        				  e -> new Age(Integer.valueOf(e.getKey())), 
        				  e -> getUser(e.getValue())
        		  )
            );
        
    }
    
    public User getUser(JsonElement jsonElement) {
    	JsonObject rootObject = jsonElement.getAsJsonObject();
    	String name = rootObject.get("name").getAsString();
    	return new User(name);
    }

}