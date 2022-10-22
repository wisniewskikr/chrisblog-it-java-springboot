package com.example.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.commands.ViewCommand;
import com.example.app.entities.BookingEntity;
import com.example.app.repositories.BookingRepository;

@Controller
public class ViewController {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@RequestMapping(value="/view")
	public String displayPage(@ModelAttribute("command")ViewCommand command,
			HttpSession session) {
		
		Long id = (Long)session.getAttribute("selectedBookingId");
		BookingEntity bookingEntity = bookingRepository.findById(id).get();
		
		command.setDateFrom(bookingEntity.getDateFromFormatted());
		command.setTimeFrom(bookingEntity.getTimeFromFormatted());
		command.setDateTo(bookingEntity.getDateToFormatted());
		command.setTimeTo(bookingEntity.getTimeToFormatted());
		command.setRoom(bookingEntity.getRoomNumber());
		
		return "view";
		
	}

}