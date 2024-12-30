package com.example.vrs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vrs.entity.Location;
import com.example.vrs.entity.VehicleListing;
import com.example.vrs.exceptions.VehicleListingException;
import com.example.vrs.mapper.LocationMapper;
import com.example.vrs.repository.LocationRepository;
import com.example.vrs.repository.VehicleListingRepository;
import com.example.vrs.requestdto.LocationRequest;
import com.example.vrs.responsedto.LocationResponse;
import com.example.vrs.security.AuthUtil;

@Service
public class LocationService {

	private final LocationRepository locationRepository;
	private final LocationMapper locationMapper;
	private final AuthUtil authUtil;
	private final VehicleListingRepository vehicleListingRepository;

	public LocationService(LocationRepository locationRepository, LocationMapper locationMapper, AuthUtil authUtil,
			VehicleListingRepository vehicleListingRepository) {
		super();
		this.locationRepository = locationRepository;
		this.locationMapper = locationMapper;
		this.authUtil = authUtil;
		this.vehicleListingRepository = vehicleListingRepository;
	}

	public LocationResponse addLocation(LocationRequest request) {

		Location location = locationMapper.mapToLocation(request);
		location.setUser(authUtil.getCurrentUser());
		location = locationRepository.save(location);

		return locationMapper.mapToLocationResponse(location);
	}

	public List<LocationResponse> findAllLocationsByVehicleListing(int vehicleListingId) {

		VehicleListing vehicle = vehicleListingRepository.findById(vehicleListingId)
				.orElseThrow(() -> new VehicleListingException("Vehicle Listing not Found by Id"));

		List<Location> locations = locationRepository.findAllByVehicleListings(vehicle);
		List<LocationResponse> locationResponses = new ArrayList<LocationResponse>();

		for (Location location : locations) {

			locationResponses.add(locationMapper.mapToLocationResponse(location));
		}
		return locationResponses;
	}

}
