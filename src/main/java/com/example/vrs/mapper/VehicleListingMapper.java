package com.example.vrs.mapper;

import org.springframework.stereotype.Component;
import com.example.vrs.entity.VehicleListing;
import com.example.vrs.requestdto.VehicleListingRequest;
import com.example.vrs.responsedto.VehicleListingResponse;

@Component
public class VehicleListingMapper {

	public VehicleListing mapToVehicleListing(VehicleListingRequest request) {

		VehicleListing listing = new VehicleListing();
		
		listing.setVehicleNumber(request.getVehicleNumber());
		listing.setPricePerDay(request.getPricePerDay());
		listing.setSeating(request.getSeating());
		

		return listing;
	}

	public VehicleListingResponse mapToVehicleListingResponse(VehicleListing listing) {

		VehicleListingResponse response = new VehicleListingResponse();

		response.setListingId(listing.getListingId());
		response.setPricePerDay(listing.getPricePerDay());
		response.setSeating(listing.getSeating());
		response.setVehicleNumber(listing.getVehicleNumber());

		return response;

	}
}
