package com.example.app.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.example.app.entities.BookingEntity;
import com.example.app.repositories.BookingRepository;

@Service
public class BookingService {
	
	private BookingRepository bookingRepository;
	
	@Autowired
	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}
	
	public BookingEntity save(BookingEntity bookingEntity) {
		return bookingRepository.save(bookingEntity);
	}
	
	public BookingEntity findById(Long id) {
		return bookingRepository.findById(id).get();
	}
	
	public boolean isBookingValid(Integer roomNumber, Date from, Date to, BindingResult result) {
		
		List<BookingEntity> bookings = bookingRepository.findBookingsForRoomInTimeScope(roomNumber, from, to);
		if (!bookings.isEmpty()) {
			
			for (BookingEntity booking : bookings) {
				
				String errorMessage = String.format("Room %s is already booked from %s to %s.", 
						booking.getRoomNumber(), booking.getTimestampFromFormatted(), booking.getTimestampToFormatted());
				ObjectError error = new ObjectError("globalError", errorMessage);
		        result.addError(error);
		        
			}			
			
	        return false;
		}
		
		return true;
		
	}

}
