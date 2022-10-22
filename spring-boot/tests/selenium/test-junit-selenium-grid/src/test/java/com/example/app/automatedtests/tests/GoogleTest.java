package com.example.app.automatedtests.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import com.example.app.automatedtests.abstr.AbstractAT;
import com.example.app.automatedtests.pages.GooglePage;

public class GoogleTest extends AbstractAT {
	
	@Test
	public void test01() {
		GooglePage googlePage = PageFactory.initElements(driver, GooglePage.class);
		googlePage
			.open()
			.check()
				.title("Google");
	}

}
