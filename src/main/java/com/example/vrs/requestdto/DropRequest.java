package com.example.vrs.requestdto;

import java.time.LocalDate;
import java.time.LocalTime;

public class DropRequest {

	private LocalDate localDate;
	private  LocalTime localTime;
	
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
}
