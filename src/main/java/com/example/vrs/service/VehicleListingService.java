package com.example.vrs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vrs.entity.Location;
import com.example.vrs.entity.User;
import com.example.vrs.entity.Vehicle;
import com.example.vrs.entity.VehicleListing;
import com.example.vrs.exceptions.LocationNotFoundException;
import com.example.vrs.exceptions.VehicleListingException;
import com.example.vrs.exceptions.VehicleNotFoundExcepction;
import com.example.vrs.mapper.VehicleListingMapper;
import com.example.vrs.repository.LocationRepository;
import com.example.vrs.repository.VehicleListingRepository;
import com.example.vrs.repository.VehicleRepository;
import com.example.vrs.requestdto.VehicleListingRequest;
import com.example.vrs.responsedto.VehicleListingResponse;
import com.example.vrs.security.AuthUtil;

@Service
public class VehicleListingService {

	private final VehicleListingRepository vehicleListingRepository;
	private final VehicleRepository vehicleRepository;
	private final VehicleListingMapper vehicleListingMapper;
	private final AuthUtil authUtil;
	private final LocationRepository locationRepository;

	public VehicleListingService(VehicleListingRepository vehicleListingRepository, VehicleRepository vehicleRepository,
			VehicleListingMapper vehicleListingMapper, AuthUtil authUtil,LocationRepository locationRepository) {
		super();
		this.vehicleListingRepository = vehicleListingRepository;
		this.vehicleRepository = vehicleRepository;
		this.vehicleListingMapper = vehicleListingMapper;
		this.authUtil = authUtil;
		this.locationRepository = locationRepository;
	}

	public VehicleListingResponse insert(VehicleListingRequest vehicleListingRequest, int vehicleId) {

		VehicleListing listing = vehicleListingMapper.mapToVehicleListing(vehicleListingRequest);

		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new VehicleNotFoundExcepction("Vehicle not found By given Id"));

		User rentingPartner = authUtil.getCurrentUser();

		listing.setRentingPartner(rentingPartner);
		listing.setVehicle(vehicle);

		listing = vehicleListingRepository.save(listing);

		return vehicleListingMapper.mapToVehicleListingResponse(listing);

	}

	public List<VehicleListingResponse> findAllVehicleList(int vehicleId) {

		List<VehicleListing> vehicleListings = vehicleListingRepository.findAllByVehicleId(vehicleId);
		List<VehicleListingResponse> vehicleListingResponses = new ArrayList<VehicleListingResponse>();

		for (VehicleListing vehicleListing : vehicleListings) {
			vehicleListingResponses.add(vehicleListingMapper.mapToVehicleListingResponse(vehicleListing));
		}

		return vehicleListingResponses;
	}

	public void updateLocationIntoVehicleListing(int locationId, int vehicleListingId) {
		
		Location location = locationRepository.findById(locationId).orElseThrow(() -> new LocationNotFoundException("Location Not Found By Id"));
		VehicleListing listing = vehicleListingRepository.findById(vehicleListingId).orElseThrow(() -> new VehicleListingException("VehicleListing Not Found By Id"));
		
		listing.getLocations().add(location);
		location.getVehicleListings().add(listing);
		
		locationRepository.save(location);
		vehicleListingRepository.save(listing);
		
		
	}

}
