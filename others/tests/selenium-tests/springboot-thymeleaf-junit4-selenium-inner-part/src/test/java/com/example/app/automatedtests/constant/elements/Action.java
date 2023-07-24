package com.example.app.automatedtests.constant.elements;

import org.openqa.selenium.WebElement;

public class Action {
	
	public Action webElementSendKeys(WebElement webElement, String nameValue) {
		webElement.sendKeys(nameValue);
		return this;
	}
	
	public Action webElementClick(WebElement webElement) {
		webElement.click();
		return this;
	}

}
