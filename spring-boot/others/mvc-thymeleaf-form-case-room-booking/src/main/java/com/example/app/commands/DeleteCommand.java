package com.example.app.commands;

public class DeleteCommand {
	
	private String timestampFrom;
	private String timestampTo;
	private Integer room;
	
	public String getTimestampFrom() {
		return timestampFrom;
	}
	public void setTimestampFrom(String timestampFrom) {
		this.timestampFrom = timestampFrom;
	}
	public String getTimestampTo() {
		return timestampTo;
	}
	public void setTimestampTo(String timestampTo) {
		this.timestampTo = timestampTo;
	}
	public Integer getRoom() {
		return room;
	}
	public void setRoom(Integer room) {
		this.room = room;
	}			
	
}
