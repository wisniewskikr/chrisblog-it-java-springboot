package com.example.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.commands.DeleteCommand;
import com.example.app.entities.BookingEntity;
import com.example.app.repositories.BookingRepository;

@Controller
public class DeleteController {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@RequestMapping(value="/delete")
	public String displayPage(@ModelAttribute("command")DeleteCommand command,
			HttpSession session) {
		
		Long id = (Long)session.getAttribute("selectedBookingId");
		BookingEntity bookingEntity = bookingRepository.findById(id).get();
		
		command.setTimestampFrom(bookingEntity.getTimestampFromFormatted());
		command.setTimestampTo(bookingEntity.getTimestampToFormatted());
		command.setRoom(bookingEntity.getRoomNumber());
		
		return "delete";
		
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String handleButtonEdit(@ModelAttribute("command")DeleteCommand command,
			HttpSession session) {
		
		Long id = (Long)session.getAttribute("selectedBookingId");	
		bookingRepository.deleteById(id);
		return "redirect:/list";
		
	}

}