package com.example.app.automatedtests.constant.abstr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.app.automatedtests.constant.elements.Action;
import com.example.app.automatedtests.constant.elements.Check;

public abstract class AbstractPage {
	
	private static final int TIME_OUT_IN_SECONDS = 15;
	private String path;
	private int port;	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Check check;
	protected Action action;
	
	public AbstractPage(WebDriver driver, String path) {
		this.driver = driver;
		this.path = path;
		this.wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
	}
	
	public AbstractPage(WebDriver driver, String path, int port) {
		this.driver = driver;
		this.path = path;
		this.port = port;
		this.wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
	}
	
	public void open(int port){
		driver.get(String.format(path, port));
    }
	
	public void open(){
		driver.get(String.format(path, port));
    }
	
	public Check check(){
        if (check != null) {
            return check;
        }
        check = new Check();
        return check;
    }
	
	public Action action(){
        if (action != null) {
            return action;
        }
        action = new Action();
        return action;
    }

}
