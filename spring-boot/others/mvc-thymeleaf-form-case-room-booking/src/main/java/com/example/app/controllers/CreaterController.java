package com.example.app.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.commands.CreateCommand;
import com.example.app.entities.BookingEntity;
import com.example.app.services.BookingService;
import com.example.app.utils.DateUtils;
import com.example.app.utils.ValuesUtils;

@Controller
public class CreaterController {
	
	private BookingService bookingService;
	
	@Autowired
	public CreaterController(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	@ModelAttribute
	public void addAttributes(Model model) {
	    model.addAttribute("timeFromValues", ValuesUtils.getTimeValues());
	    model.addAttribute("timeToValues", ValuesUtils.getTimeValues());
	    model.addAttribute("roomValues", ValuesUtils.getRoomValues());
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String displayPage(@ModelAttribute("command")CreateCommand command) {
		return "create";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String handleCreate(@ModelAttribute("command")CreateCommand command, BindingResult result) {
		
		Date from = DateUtils.joinDateAndTime(command.getDateFrom(), command.getTimeFrom());
		Date to = DateUtils.joinDateAndTime(command.getDateTo(), command.getTimeTo());
		
		if (!bookingService.isBookingValid(command.getRoom(), from, to, result))
			return "create";
				
		bookingService.save(new BookingEntity(from, to, command.getRoom()));		
		return "redirect:/list";
		
	}

}