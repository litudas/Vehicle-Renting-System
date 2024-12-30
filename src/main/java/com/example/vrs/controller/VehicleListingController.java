package com.example.vrs.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.vrs.requestdto.VehicleListingRequest;
import com.example.vrs.responsedto.VehicleListingResponse;
import com.example.vrs.service.VehicleListingService;
import com.example.vrs.util.ResponseStructure;
import com.example.vrs.util.SimpleResponseStructure;

@RestController
public class VehicleListingController {

	private final VehicleListingService vehicleListingService;

	public VehicleListingController(VehicleListingService vehicleListingService) {
		super();
		this.vehicleListingService = vehicleListingService;
	}

	@PreAuthorize("hasAuthority('RENTING_PARTNER')")
	@PostMapping("/insert/vehicle")
	public ResponseEntity<ResponseStructure<VehicleListingResponse>> insert(@RequestBody VehicleListingRequest request,
			@RequestParam("vehicleId") int vehicleId) {

		VehicleListingResponse response = vehicleListingService.insert(request, vehicleId);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "Vehicle Inserted Successfully", response));

	}

	@GetMapping("/find-all/listed-vehicles")
	public ResponseEntity<ResponseStructure<List<VehicleListingResponse>>> findAllVehicleList(
			@RequestParam("vehicleId") int vehicleId) {

		List<VehicleListingResponse> vehicleListingResponses = vehicleListingService.findAllVehicleList(vehicleId);

		return ResponseEntity.status(HttpStatus.FOUND).body(
				ResponseStructure.create(HttpStatus.FOUND.value(), "Vehicle Listings fetched", vehicleListingResponses));

	}
	
	@PreAuthorize("hasAuthority('RENTING_PARTNER')")
	@PutMapping("/update-location-into-vehicvleisting")
	public ResponseEntity<SimpleResponseStructure> updateLocationIntoVehicleListing(@RequestParam int locationId,@RequestParam int vehicleListingId) {

		vehicleListingService.updateLocationIntoVehicleListing(locationId,vehicleListingId);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(SimpleResponseStructure.create(HttpStatus.CREATED.value(), "Location inserted into Vehicle Listing Successfully"));
	}
}
