package com.example.vrs.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.vrs.entity.Vehicle;
import com.example.vrs.service.VehicleService;
import com.example.vrs.util.ResponseStructure;

@RestController
public class VehicleController {

	private final VehicleService vehicleService;

	public VehicleController(VehicleService vehicleService) {
		super();
		this.vehicleService = vehicleService;
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/save-vehicle")
	public ResponseEntity<ResponseStructure<Vehicle>> addVehicle(@RequestBody Vehicle vehicle) {

		vehicle = vehicleService.addVehicle(vehicle);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "Vehicles Created", vehicle));
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping("/update-vehicle")
	public ResponseEntity<ResponseStructure<Vehicle>> updateVehicle(@RequestBody Vehicle vehicle) {

		vehicle = vehicleService.updateVehicle(vehicle);

		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseStructure.create(HttpStatus.OK.value(), "Updated Successfully", vehicle));
	}

	@GetMapping("/find-all-vehicle")
	public ResponseEntity<ResponseStructure<List<Vehicle>>> findAllVehicle() {

		List<Vehicle> vehicles = vehicleService.findAllVehicle();

		return ResponseEntity.status(HttpStatus.FOUND)
				.body(ResponseStructure.create(HttpStatus.FOUND.value(), "Vehicles are found", vehicles));
	}

}
