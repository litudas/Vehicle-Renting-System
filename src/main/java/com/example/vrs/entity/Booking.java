package com.example.vrs.entity;

import java.time.Duration;

import com.example.vrs.enums.BookingStatus;
import com.example.vrs.enums.RentingType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private double totalPayableAmount;
	private RentingType rentingType;
	private Duration duration;
	private BookingStatus bookingStatus;

	@OneToOne
	private PickUp pickUp;
	@OneToOne
	private Drop drop;
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	private VehicleListing vehicleListing;

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

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public VehicleListing getVehicleListing() {
		return vehicleListing;
	}

	public void setVehicleListing(VehicleListing vehicleListing) {
		this.vehicleListing = vehicleListing;
	}

	public Drop getDrop() {
		return drop;
	}

	public void setDrop(Drop drop) {
		this.drop = drop;
	}

	public PickUp getPickUp() {
		return pickUp;
	}

	public void setPickUp(PickUp pickUp) {
		this.pickUp = pickUp;
	}

}
