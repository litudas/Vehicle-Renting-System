package com.example.vrs.requestdto;

import com.example.vrs.enums.VehicleSeating;

public class VehicleListingRequest {

	private VehicleSeating seating;
	private String vehicleNumber;
	private double pricePerDay;
	
	public VehicleSeating getSeating() {
		return seating;
	}
	public void setSeating(VehicleSeating seating) {
		this.seating = seating;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	
}
