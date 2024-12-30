package com.example.vrs.responsedto;

import java.util.List;
import com.example.vrs.enums.FuelType;
import com.example.vrs.enums.VehicleType;

public class VehicleResponse {

	private int vehicleId;
	private String brand;
	private String model;
	private VehicleType vehicleType;
	private FuelType fuelType;
	private List<Integer> imagesLink;
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public FuelType getFuelType() {
		return fuelType;
	}
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
	public List<Integer> getImagesLink() {
		return imagesLink;
	}
	public void setImagesLink(List<Integer> imagesLink) {
		this.imagesLink = imagesLink;
	}
	
	
	
}
