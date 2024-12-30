package com.example.vrs.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.vrs.requestdto.LocationRequest;
import com.example.vrs.responsedto.LocationResponse;
import com.example.vrs.service.LocationService;
import com.example.vrs.util.ResponseStructure;

@RestController
public class LocationController {

	private final LocationService locationService;

	public LocationController(LocationService locationService) {
		super();
		this.locationService = locationService;
	}

	@PreAuthorize("hasAuthority('RENTING_PARTNER')")
	@PostMapping("/add-location")
	public ResponseEntity<ResponseStructure<LocationResponse>> addLocation(@RequestBody LocationRequest request) {

		LocationResponse response = locationService.addLocation(request);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "Location Created Successfully", response));

	}

	@GetMapping("/find-all/locations")
	public ResponseEntity<ResponseStructure<List<LocationResponse>>> findAllLocations(@RequestParam("vehicleListingId") int vehicleListingId) {

		List<LocationResponse> responses = locationService.findAllLocationsByVehicleListing(vehicleListingId);

		return ResponseEntity.status(HttpStatus.FOUND).body(
				ResponseStructure.create(HttpStatus.FOUND.value(), "Locations are fetched", responses));

	}

}
