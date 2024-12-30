package com.example.vrs.mapper;

import org.springframework.stereotype.Component;

import com.example.vrs.entity.Booking;
import com.example.vrs.requestdto.BookingRequest;
import com.example.vrs.responsedto.BookingResponse;

@Component
public class BookingMapper {

	public Booking mapToBooking(BookingRequest request) {

		Booking booking = new Booking();

		booking.setBookingStatus(request.getBookingStatus());
		booking.setTotalPayableAmount(request.getTotalPayableAmount());
		booking.setRentingType(request.getRentingType());
		//booking.setDuration(request.getDuration());

		return booking;
	}

	public BookingResponse mapToBookingResponse(Booking booking) {

		BookingResponse response = new BookingResponse();

		response.setBookingId(booking.getBookingId());
		response.setBookingStatus(booking.getBookingStatus());
		response.setTotalPayableAmount(booking.getTotalPayableAmount());
		response.setRentingType(booking.getRentingType());
		//response.setDuration(booking.getDuration());

		return response;
	}
}
