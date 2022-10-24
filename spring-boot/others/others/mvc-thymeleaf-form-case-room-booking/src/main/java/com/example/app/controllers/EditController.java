package com.example.app.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.commands.EditCommand;
import com.example.app.entities.BookingEntity;
import com.example.app.services.BookingService;
import com.example.app.utils.DateUtils;
import com.example.app.utils.ValuesUtils;

@Controller
public class EditController {
	
	private BookingService bookingService;
	
	@Autowired
	public EditController(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	@ModelAttribute
	public void addAttributes(Model model) {
	    model.addAttribute("timeFromValues", ValuesUtils.getTimeValues());
	    model.addAttribute("timeToValues", ValuesUtils.getTimeValues());
	    model.addAttribute("roomValues", ValuesUtils.getRoomValues());
	}
	
	@RequestMapping(value="/edit")
	public String displayPage(@ModelAttribute("command")EditCommand command,
			HttpSession session) {
		
		Long id = (Long)session.getAttribute("selectedBookingId");			
		BookingEntity bookingEntity = bookingService.findById(id);
		
		command.setDateFrom(bookingEntity.getDateFromFormatted());
		command.setTimeFrom(bookingEntity.getTimeFromFormatted());
		command.setDateTo(bookingEntity.getDateToFormatted());
		command.setTimeTo(bookingEntity.getTimeToFormatted());
		command.setRoom(bookingEntity.getRoomNumber());
		
		return "edit";
		
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String handleButtonEdit(@ModelAttribute("command")EditCommand command,
			HttpSession session, BindingResult result) {
		
		Long id = (Long)session.getAttribute("selectedBookingId");
		Date from = DateUtils.joinDateAndTime(command.getDateFrom(), command.getTimeFrom());
		Date to = DateUtils.joinDateAndTime(command.getDateTo(), command.getTimeTo());
		
		if (!bookingService.isBookingValid(command.getRoom(), from, to, result))
			return "edit";
		
		bookingService.save(new BookingEntity(id, from, to, command.getRoom()));
		
		return "redirect:/list";
		
	}

}