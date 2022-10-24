package com.example.app.automatedtests.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class GreetingPage {
	
	private static final String PATH = "http://localhost:%s/app/greeting";
	private WebDriver driver;
	private Check check;
	
	@FindBy(how = How.ID, id = "greetingText")
    private WebElement greetingText;
	

	public GreetingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public GreetingPage open(int port){
		driver.get(String.format(PATH, port));
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
        
        public Check text(String expected){
            assertEquals(expected, greetingText.getText());
            return this;
        }
        
    }
	
	

}
