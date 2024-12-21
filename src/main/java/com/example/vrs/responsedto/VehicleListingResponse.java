package com.example.vrs.responsedto;

import com.example.vrs.enums.VehicleSeating;

public class VehicleListingResponse {

	private int listingId;
    private double pricePerDay;
    private VehicleSeating seating;
    private String vehicleNumber;
	
	public int getListingId() {
		return listingId;
	}
	public void setListingId(int listingId) {
		this.listingId = listingId;
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
	public VehicleSeating getSeating() {
		return seating;
	}
	public void setSeating(VehicleSeating seating) {
		this.seating = seating;
	}
	
	
    
    
}
