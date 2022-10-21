package com.example.app.controllers.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.app.application.Application;
import com.example.app.commands.greeting.GreetingCommand;

@SpringBootTest(classes = Application.class)
class GreetingControllerTest extends AbstractTestNGSpringContextTests {
	
	@Autowired
	private GreetingController controller;

	@Test
	void greeting() {
		GreetingCommand command = new GreetingCommand();
		
		String page = controller.greeting(command);
		
		Assert.assertEquals("greeting/greeting", page);
		Assert.assertEquals("Hello World!", command.getText());
	}

}
