package com.example.app.automatedtests.custom.tests.common;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.PageFactory;

import com.example.app.automatedtests.constant.abstr.AbstractAT;
import com.example.app.automatedtests.constant.parts.PartSpringRunner;
import com.example.app.automatedtests.custom.pages.InputPage;
import com.example.app.automatedtests.custom.pages.OutputPage;

@RunWith(PartSpringRunner.class)
public class OutputTest extends AbstractAT {
	
	@Test	
	public void test01() {
		
		InputPage inputPage = PageFactory.initElements(driver, InputPage.class);
		OutputPage outputPage = PageFactory.initElements(driver, OutputPage.class);
		
		inputPage
			.open(port);
			
		inputPage
			.action()
				.webElementSendKeys(InputPage.NAME, "Chris")
				.webElementClick(InputPage.SUBMIT);
		
		outputPage
			.check()
				.title(driver, "Output Page")
				.webElementText(OutputPage.HEADER, "Output Page")
				.webElementText(OutputPage.MESSAGE, "Hello World:")
				.webElementText(OutputPage.NAME, "Chris");
						
		outputPage
			.action()
				.webElementClick(OutputPage.BACK);
		
		inputPage
			.check()
				.title(driver, "Input Page");
		
	}
	
	@Test	
	public void test02() {		
		assertTrue(true);		
	}

}
