package com.example.app.automatedtests.custom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.example.app.automatedtests.constant.abstr.AbstractPage;


public class InputPage extends AbstractPage {	

	private static final String PAGE_PATH = "http://localhost:%s/input";
	
	@FindBy(how = How.ID, id = "header")
    public static WebElement HEADER;
	
	@FindBy(how = How.ID, id = "nameLabel")
    public static WebElement NAME_LABEL;
	
	@FindBy(how = How.ID, id = "nameHelp")
    public static WebElement NAME_HELP;
	
	@FindBy(how = How.ID, id = "name")
    public static WebElement NAME;
	
	@FindBy(how = How.ID, id = "submit")
    public static WebElement SUBMIT;
	
	
	public InputPage(WebDriver driver, int port) {
		super(driver, PAGE_PATH);
	}	

}
