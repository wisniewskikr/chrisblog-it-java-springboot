package com.example.app.controllers.greeting;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.app.commands.greeting.GreetingCommand;

class GreetingControllerTest {
	
	private GreetingController controller;

	@BeforeClass
	void setUp() throws Exception {
		controller = new GreetingController();
	}

	@Test
	void greeting() {
		GreetingCommand command = new GreetingCommand();
		
		String page = controller.greeting(command);
		
		Assert.assertEquals("greeting/greeting", page);
		Assert.assertEquals("Hello World!", command.getText());
	}

}
