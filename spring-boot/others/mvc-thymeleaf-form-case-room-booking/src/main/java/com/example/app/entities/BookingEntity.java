package com.example.app.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="BOOKING")
public class BookingEntity {	

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeFrom;
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeTo;
	private Integer roomNumber;
	
	@Transient
	private String timestampFromFormatted;
	@Transient
	private String timestampToFormatted;
	@Transient
	private String dateFromFormatted;
	@Transient
	private String dateToFormatted;
	@Transient
	private String timeFromFormatted;
	@Transient
	private String timeToFormatted;
	
	public BookingEntity(Long id, Date timeFrom, Date timeTo, Integer roomNumber) {
		this.id = id;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.roomNumber = roomNumber;
	}
	
	public BookingEntity(Date timeFrom, Date timeTo, Integer roomNumber) {
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.roomNumber = roomNumber;
	}

	public BookingEntity() {}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public Date getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(Date timeFrom) {
		this.timeFrom = timeFrom;
	}
	public Date getTimeTo() {
		return timeTo;
	}
	public void setTimeTo(Date timeTo) {
		this.timeTo = timeTo;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getTimestampFromFormatted() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(timeFrom);
	}
	public String getTimestampToFormatted() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(timeTo);
	}
	public String getDateFromFormatted() {
		return new SimpleDateFormat("MM/dd/yyyy").format(timeFrom);
	}
	public String getDateToFormatted() {
		return new SimpleDateFormat("MM/dd/yyyy").format(timeTo);
	}
	public String getTimeFromFormatted() {
		return new SimpleDateFormat("HH:mm").format(timeFrom);
	}
	public String getTimeToFormatted() {
		return new SimpleDateFormat("HH:mm").format(timeTo);
	}	
		

}
