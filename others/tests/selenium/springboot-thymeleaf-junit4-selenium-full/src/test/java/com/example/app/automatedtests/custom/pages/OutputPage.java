package com.example.app.automatedtests.custom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.example.app.automatedtests.constant.abstr.AbstractPage;


public class OutputPage extends AbstractPage {
	
	private static final String PAGE_PATH = "http://localhost:%s/output";
	
	@FindBy(how = How.ID, id = "header")
    public static WebElement HEADER;
	
	@FindBy(how = How.ID, id = "message")
    public static WebElement MESSAGE;
	
	@FindBy(how = How.ID, id = "name")
    public static WebElement NAME;
	
	@FindBy(how = How.ID, id = "back")
    public static WebElement BACK;
	

	public OutputPage(WebDriver driver) {
		super(driver, PAGE_PATH);
	}	

}
