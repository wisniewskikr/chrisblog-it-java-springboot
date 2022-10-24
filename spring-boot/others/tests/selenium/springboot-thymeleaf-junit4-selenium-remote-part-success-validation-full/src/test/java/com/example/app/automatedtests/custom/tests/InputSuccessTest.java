package com.example.app.automatedtests.custom.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.PageFactory;

import com.example.app.automatedtests.constant.abstr.AbstractAT;
import com.example.app.automatedtests.constant.utils.CustomSpringRunner;
import com.example.app.automatedtests.custom.pages.InputPage;
import com.example.app.automatedtests.custom.pages.OutputPage;

@RunWith(CustomSpringRunner.class)
public class InputSuccessTest extends AbstractAT {
	
	@Test
	public void test01() {
		
		InputPage inputPage = PageFactory.initElements(driver, InputPage.class);
		OutputPage outputPage = PageFactory.initElements(driver, OutputPage.class);
		
		inputPage
			.open();
		
		inputPage
			.check()
				.title(driver, "Input Page")
				.webElementText(InputPage.HEADER, "Input Page")
				.webElementText(InputPage.NAME_LABEL, "Name")
				.webElementText(InputPage.NAME_HELP, "Please type you name here.");
		
		inputPage
			.action()
				.webElementSendKeys(InputPage.NAME, "Chris")
				.webElementClick(InputPage.SUBMIT);
		
		outputPage
			.check()
				.title(driver, "Output Page");
		
	}

}
