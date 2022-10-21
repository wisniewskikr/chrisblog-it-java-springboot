package com.example.app.controllers.greeting;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.example.app.commands.greeting.GreetingCommand;

public class GreetingControllerTest {
	
	private GreetingController controller;

	@Before
	public void setUp() throws Exception {
		controller = new GreetingController();
	}

	@Test
	public void greeting() {
		GreetingCommand command = new GreetingCommand();
		
		String page = controller.greeting(command);
		
		assertEquals("greeting/greeting", page);
		assertEquals("Hello World!", command.getText());
	}

}
