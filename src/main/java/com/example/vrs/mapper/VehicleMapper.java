package com.example.vrs.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.example.vrs.entity.Image;
import com.example.vrs.entity.Vehicle;
import com.example.vrs.responsedto.VehicleResponse;

@Component
public class VehicleMapper {

	public VehicleResponse mapToResponse(Vehicle vehicle) {

		VehicleResponse response = new VehicleResponse();

		response.setVehicleId(vehicle.getVehicleId());
		response.setBrand(vehicle.getBrand());
		response.setModel(vehicle.getModel());
		response.setVehicleType(vehicle.getType());
		response.setFuelType(vehicle.getFuelType());

		if (vehicle.getVehicleImages() != null) {
			List<Integer> imageIds = vehicle.getVehicleImages().stream().map(Image::getImageId)
					.collect(Collectors.toList());
			response.setImagesLink(imageIds);
		}
		return response;
	}

	public List<VehicleResponse> mapToResponsesList(List<Vehicle> vehicles) {

		return vehicles.stream().map(this::mapToResponse).collect(Collectors.toList());
	}
}
