package com.example.app.automatedtests.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.example.app.automatedtests.abstr.AbstractAT;
import com.example.app.automatedtests.pages.GreetingPage;

public class GreetingTest extends AbstractAT {
	
	@Test
	public void test01() {
		GreetingPage greetingPage = PageFactory.initElements(driver, GreetingPage.class);
		greetingPage
			.open()
			.check()
				.title("Hello World")
				.text("Hello World!");
	}

}
