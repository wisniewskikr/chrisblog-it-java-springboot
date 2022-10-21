package com.example.app.automatedtests.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import com.example.app.Application;
import com.example.app.automatedtests.abstr.AbstractAT;
import com.example.app.automatedtests.pages.InputPage;
import com.example.app.automatedtests.pages.OutputPage;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class OutputTest extends AbstractAT {
	
	@LocalServerPort
	protected int port;
	
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

}
