package com.example.vrs.responsedto;

import java.time.LocalDate;
import java.time.LocalTime;

public class DropResponse {

	private int dropId;
	private LocalDate localDate;
	private  LocalTime localTime;
	private LocationResponse location;
	
	public int getDropId() {
		return dropId;
	}
	public void setDropId(int pickupId) {
		this.dropId = pickupId;
	}
	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	public LocalTime getLocalTime() {
		return localTime;
	}
	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}
	public LocationResponse getLocation() {
		return location;
	}
	public void setLocation(LocationResponse location) {
		this.location = location;
	}
	
}
