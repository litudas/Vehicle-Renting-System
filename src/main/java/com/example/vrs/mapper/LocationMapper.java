package com.example.vrs.mapper;

import org.springframework.stereotype.Component;
import com.example.vrs.entity.Location;
import com.example.vrs.requestdto.LocationRequest;
import com.example.vrs.responsedto.LocationResponse;

@Component
public class LocationMapper {

	public Location mapToLocation(LocationRequest request) {

		Location location = new Location();

		location.setPhoneNumber(request.getPhoneNumber());
		location.setArea(request.getArea());
		location.setCity(request.getCity());
		location.setPincode(request.getPincode());
		location.setAddressLine(request.getAddressLine());
		location.setAddressLineOptional(request.getAddressLineOptional());
		location.setState(request.getState());
		location.setCountry(request.getCountry());

		return location;
	}

	public LocationResponse mapToLocationResponse(Location location) {

		LocationResponse response = new LocationResponse();

		response.setLocationId(location.getLocationId());
		response.setAddressLine(location.getAddressLine());
		response.setAddressLineOptional(location.getAddressLineOptional());
		response.setArea(location.getArea());
		response.setCity(location.getCity());
		response.setState(location.getState());
		response.setCountry(location.getCountry());
		response.setPincode(location.getPincode());
		response.setPhoneNumber(location.getPhoneNumber());

		return response;
	}
}
