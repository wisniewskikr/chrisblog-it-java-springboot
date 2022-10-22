package com.example.app.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static Date joinDateAndTime(String date, String time) {
		
		Date result = null;
		
		try {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy hh:mm");		   
		    result = new Date(dateFormat.parse(date + " " + time).getTime());
		} catch(Exception e) { //this generic but you can control another types of exception
		    System.err.println(e); 
		}
		
		return result;
		
	}

}
