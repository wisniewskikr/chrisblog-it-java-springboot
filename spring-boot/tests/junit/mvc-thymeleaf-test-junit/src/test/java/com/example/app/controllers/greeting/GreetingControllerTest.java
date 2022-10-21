package com.example.app.controllers.greeting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.app.application.Application;
import static org.hamcrest.Matchers.hasProperty;

import org.hamcrest.Matchers;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
class GreetingControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testGreeting() throws Exception {
		
		this.mockMvc
		.perform(MockMvcRequestBuilders.get("/greeting"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("greeting/greeting"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("command"))
		.andExpect(MockMvcResultMatchers.model().attribute("command", hasProperty("text", Matchers.equalTo("Hello World!"))));
		
	}

}
