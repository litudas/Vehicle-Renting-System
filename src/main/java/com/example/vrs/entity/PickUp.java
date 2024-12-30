package com.example.vrs.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class PickUp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pickupId;
	private LocalDate localDate;
	private  LocalTime localTime;
	
	@OneToOne
	private Location location;

	public int getPickupId() {
		return pickupId;
	}

	public void setPickupId(int pickupId) {
		this.pickupId = pickupId;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
