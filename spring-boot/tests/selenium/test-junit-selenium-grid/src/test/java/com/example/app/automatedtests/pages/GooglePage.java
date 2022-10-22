package com.example.app.automatedtests.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;


public class GooglePage {
	
	private static final String PATH = "https://www.google.com";
	private WebDriver driver;
	private Check check;
	

	public GooglePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public GooglePage open(){
		driver.get(PATH);
		return this;
    }
	
	public Check check(){
        if (check != null) {
            return check;
        }
        check = new Check();
        return check;
    }

    public class Check{

        public Check title(String expected){
            assertEquals(expected, driver.getTitle());
            return this;
        }
        
    }
	
	

}
