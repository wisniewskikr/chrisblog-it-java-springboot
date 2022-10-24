package com.example.app.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValuesUtils {
	
	public static List<String> getTimeValues() {
		
	    int interval = 30; //minutes interval
	    List<String> timesList=new ArrayList<String>() ; // time array
	    String timeFormat;
	    for(int h=0;h<24;h++)
	    {
	    for(int m=0;m<60;)
	    {
	        if(h<12)
	        {
	        timeFormat=String.format("%02d:%02d", h,m);
	        }
	        else
	        {
	        timeFormat=String.format("%02d:%02d", h,m);
	        }
	        timesList.add(timeFormat);
	        m=m+interval;
	        }
	 
	    }
	    
	    return timesList;
	 
	}
	
	public static List<String> getRoomValues() {
		return Arrays.asList("1", "2", "3");
	}

}
