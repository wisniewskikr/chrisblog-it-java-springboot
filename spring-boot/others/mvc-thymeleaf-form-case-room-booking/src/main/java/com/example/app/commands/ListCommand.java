package com.example.app.commands;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.app.entities.BookingEntity;

public class ListCommand implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<BookingEntity> bookings = new ArrayList<BookingEntity>();
	private Long selectedBookingId;

	public List<BookingEntity> getBookings() {
		return bookings;
	}
	public void setBookings(List<BookingEntity> bookings) {
		this.bookings = bookings;
	}
	
	public Long getSelectedBookingId() {
		return selectedBookingId;
	}
	public void setSelectedBookingId(Long selectedBookingId) {
		this.selectedBookingId = selectedBookingId;
	}	
		
}
