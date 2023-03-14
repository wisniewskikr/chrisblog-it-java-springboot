package com.example.app.automatedtests.custom.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import com.example.app.Application;
import com.example.app.automatedtests.constant.abstr.AbstractAT;
import com.example.app.automatedtests.constant.utils.CustomSpringRunner;
import com.example.app.automatedtests.custom.pages.InputPage;
import com.example.app.automatedtests.custom.pages.OutputPage;

@RunWith(CustomSpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class InputSuccessTest extends AbstractAT {
	
	@LocalServerPort
	protected int port;
	
	@Test
	public void test01() {
		
		InputPage inputPage = PageFactory.initElements(driver, InputPage.class);
		OutputPage outputPage = PageFactory.initElements(driver, OutputPage.class);
		
		inputPage
			.open(port);
		
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
