package com.example.vrs.entity;

import java.util.List;

import com.example.vrs.enums.VehicleSeating;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class VehicleListing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int listingId;
	private String vehicleNumber;
	private double pricePerDay;
	private VehicleSeating seating;

	@ManyToOne(fetch = FetchType.LAZY)
	private User rentingPartner;
	@ManyToOne(fetch = FetchType.LAZY)
	private Vehicle vehicle;
	@ManyToMany
	private List<Location> locations;

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

	public User getRentingPartner() {
		return rentingPartner;
	}

	public void setRentingPartner(User rentingPartner) {
		this.rentingPartner = rentingPartner;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public VehicleSeating getSeating() {
		return seating;
	}

	public void setSeating(VehicleSeating seating) {
		this.seating = seating;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	

}
