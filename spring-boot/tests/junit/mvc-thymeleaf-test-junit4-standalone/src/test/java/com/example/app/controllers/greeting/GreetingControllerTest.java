package com.example.app.controllers.greeting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.app.application.Application;
import com.example.app.commands.greeting.GreetingCommand;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class GreetingControllerTest {
	
	@Autowired
	private GreetingController controller;


	@Test
	public void greeting() {
		GreetingCommand command = new GreetingCommand();
		
		String page = controller.greeting(command);
		
		assertEquals("greeting/greeting", page);
		assertEquals("Hello World!", command.getText());
	}

}
