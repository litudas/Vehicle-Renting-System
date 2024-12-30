package com.example.vrs.service;

import org.springframework.stereotype.Service;

import com.example.vrs.entity.Booking;
import com.example.vrs.entity.Drop;
import com.example.vrs.entity.Location;
import com.example.vrs.entity.PickUp;
import com.example.vrs.entity.User;
import com.example.vrs.entity.Vehicle;
import com.example.vrs.entity.VehicleListing;
import com.example.vrs.exceptions.LocationNotFoundException;
import com.example.vrs.exceptions.UserNotFoundException;
import com.example.vrs.exceptions.VehicleNotFoundExcepction;
import com.example.vrs.mapper.BookingMapper;
import com.example.vrs.mapper.DropMapper;
import com.example.vrs.mapper.LocationMapper;
import com.example.vrs.mapper.PickUpMapper;
import com.example.vrs.mapper.VehicleListingMapper;
import com.example.vrs.mapper.VehicleMapper;
import com.example.vrs.repository.BookingRepository;
import com.example.vrs.repository.DropRepository;
import com.example.vrs.repository.LocationRepository;
import com.example.vrs.repository.PickUpRepository;
import com.example.vrs.repository.UserRepository;
import com.example.vrs.repository.VehicleListingRepository;
import com.example.vrs.repository.VehicleRepository;
import com.example.vrs.requestdto.BookingRequest;
import com.example.vrs.responsedto.BookingResponse;
import com.example.vrs.responsedto.DropResponse;
import com.example.vrs.responsedto.PickUpResponse;
import com.example.vrs.security.AuthUtil;

@Service
public class BookingService {

	private final BookingRepository bookingRepository;
	private final BookingMapper bookingMapper;
	private final AuthUtil authUtil;
	private final PickUpRepository pickUpRepository;
	private final PickUpMapper pickUpMapper;
	private final DropRepository dropRepository;
	private final DropMapper dropMapper;
	private final VehicleRepository vehicleRepository;
	private final VehicleMapper vehicleMapper;
	private final VehicleListingRepository vehicleListingRepository;
	private final VehicleListingMapper vehicleListingMapper;
	private final UserRepository userRepository;
	private final LocationRepository locationRepository;
	private final LocationMapper locationMapper;

	public BookingService(BookingRepository bookingRepository, BookingMapper bookingMapper, AuthUtil authUtil,
			PickUpRepository pickUpRepository, PickUpMapper pickUpMapper, DropRepository dropRepository,
			DropMapper dropMapper, VehicleRepository vehicleRepository, VehicleMapper vehicleMapper,
			VehicleListingRepository vehicleListingRepository, VehicleListingMapper vehicleListingMapper,
			UserRepository userRepository, LocationRepository locationRepository, LocationMapper locationMapper) {
		super();
		this.bookingRepository = bookingRepository;
		this.bookingMapper = bookingMapper;
		this.authUtil = authUtil;
		this.pickUpRepository = pickUpRepository;
		this.pickUpMapper = pickUpMapper;
		this.dropRepository = dropRepository;
		this.dropMapper = dropMapper;
		this.vehicleRepository = vehicleRepository;
		this.vehicleMapper = vehicleMapper;
		this.vehicleListingRepository = vehicleListingRepository;
		this.vehicleListingMapper = vehicleListingMapper;
		this.userRepository = userRepository;
		this.locationRepository = locationRepository;
		this.locationMapper = locationMapper;
	}

	public BookingResponse createBooking(BookingRequest bookingRequest, int vehicleListingId, int pickUpId,
			int dropId) {

		User currentuser = authUtil.getCurrentUser();

		VehicleListing vehicleListing = vehicleListingRepository.findById(vehicleListingId)
				.orElseThrow(() -> new VehicleNotFoundExcepction("Vehicle listing not found"));

		User user = userRepository.findById(currentuser.getUserId())
				.orElseThrow(() -> new UserNotFoundException("User not found"));

		Location pickUpLocation = locationRepository.findById(pickUpId)
				.orElseThrow(() -> new LocationNotFoundException("PickUp location not found"));

		Location dropLocation = locationRepository.findById(dropId)
				.orElseThrow(() -> new LocationNotFoundException("Drop location not found"));
		/*
		 * Fetching the Vehicle data explicitly as the Vehicle is loaded through LAZY
		 * behavior.
		 */

		Vehicle vehicle = vehicleRepository.findById(vehicleListing.getVehicle().getVehicleId())
				.orElseThrow(() -> new VehicleNotFoundExcepction("Failed to find the vehicle model"));

		PickUp pickUp = pickUpMapper.mapToPickUp(bookingRequest);
		pickUp.setLocation(pickUpLocation);

		Drop drop = dropMapper.mapToDrop(bookingRequest);
		drop.setLocation(dropLocation);

		Booking booking = bookingMapper.mapToBooking(bookingRequest);
		booking.setDrop(drop);
		booking.setPickUp(pickUp);
		booking.setUser(user);
		booking.setVehicleListing(vehicleListing);

		pickUp = pickUpRepository.save(pickUp);
		drop = dropRepository.save(drop);

		bookingRepository.save(booking);

		return this.buildBookingResponse(booking, drop, pickUp, vehicle, vehicleListing);

	}

	private BookingResponse buildBookingResponse(Booking booking, Drop drop, PickUp pickUp, Vehicle vehicle,
			VehicleListing vehicleListing) {
		
		BookingResponse response = bookingMapper.mapToBookingResponse(booking);

		DropResponse dropResponse = dropMapper.mapToDropResponse(drop);
		dropResponse.setLocation(locationMapper.mapToLocationResponse(drop.getLocation()));
		response.setDrop(dropResponse);

		PickUpResponse pickUpResponse = pickUpMapper.mapToPickUpResponse(pickUp);
		pickUpResponse.setLocation(locationMapper.mapToLocationResponse(pickUp.getLocation()));
		response.setPickUp(pickUpResponse);

		response.setModel(vehicleMapper.mapToResponse(vehicle));
		response.setVehicle(vehicleListingMapper.mapToVehicleListingResponse(vehicleListing));

		return response;
	}
}
