package com.example.vrs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vrs.requestdto.BookingRequest;
import com.example.vrs.responsedto.BookingResponse;
import com.example.vrs.service.BookingService;
import com.example.vrs.util.ResponseStructure;

@RestController
public class BookingController {

	private final BookingService bookingService;

	public BookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}

	@PostMapping("/add-booking")
	public ResponseEntity<ResponseStructure<BookingResponse>> createBooking(@RequestBody BookingRequest bookingRequest ,
			@RequestParam int vehicleListingId , @RequestParam int pickUpId , @RequestParam int dropId) {

		BookingResponse bookingResponse = bookingService.createBooking(bookingRequest,vehicleListingId,pickUpId,dropId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(
				ResponseStructure.create(HttpStatus.CREATED.value(), "Booking successfully", bookingResponse));

	}

}
