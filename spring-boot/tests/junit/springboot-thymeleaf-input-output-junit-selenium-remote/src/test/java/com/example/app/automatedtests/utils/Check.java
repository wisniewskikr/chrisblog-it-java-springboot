package com.example.app.automatedtests.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Check {
	
	public Check title(WebDriver driver, String expected){
        assertEquals(expected, driver.getTitle());
        return this;
    }
    
    public Check webElementText(WebElement webElement, String expected){
        assertEquals(expected, webElement.getText());
        return this;
    }

}
