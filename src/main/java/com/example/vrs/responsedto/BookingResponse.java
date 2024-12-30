package com.example.vrs.responsedto;

import com.example.vrs.enums.BookingStatus;
import com.example.vrs.enums.RentingType;

public class BookingResponse {

	private int bookingId;
	private double totalPayableAmount;
	private RentingType rentingType;
	private PickUpResponse pickUp;
	private DropResponse drop;
	private BookingStatus bookingStatus;
	private VehicleListingResponse vehicle;
	private VehicleResponse model;
	
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public double getTotalPayableAmount() {
		return totalPayableAmount;
	}
	public void setTotalPayableAmount(double totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}
	public RentingType getRentingType() {
		return rentingType;
	}
	public void setRentingType(RentingType rentingType) {
		this.rentingType = rentingType;
	}
	public PickUpResponse getPickUp() {
		return pickUp;
	}
	public void setPickUp(PickUpResponse pickUp) {
		this.pickUp = pickUp;
	}
	public DropResponse getDrop() {
		return drop;
	}
	public void setDrop(DropResponse drop) {
		this.drop = drop;
	}
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public VehicleListingResponse getVehicle() {
		return vehicle;
	}
	public void setVehicle(VehicleListingResponse vehicle) {
		this.vehicle = vehicle;
	}
	public VehicleResponse getModel() {
		return model;
	}
	public void setModel(VehicleResponse model) {
		this.model = model;
	}
	
	
	
	
	
}
