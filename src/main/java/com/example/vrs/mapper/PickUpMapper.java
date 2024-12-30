package com.example.vrs.mapper;

import org.springframework.stereotype.Component;
import com.example.vrs.entity.PickUp;
import com.example.vrs.requestdto.BookingRequest;
import com.example.vrs.responsedto.PickUpResponse;

@Component
public class PickUpMapper {
	
	public PickUp mapToPickUp(BookingRequest request) {

		PickUp pickUp = new PickUp();

		pickUp.setLocalDate(request.getPickUpDate());
		pickUp.setLocalTime(request.getPickUpTime());

		return pickUp;

	}

	public PickUpResponse mapToPickUpResponse(PickUp pickUp) {

		PickUpResponse response = new PickUpResponse();
		
		response.setPickupId(pickUp.getPickupId()); 
		response.setLocalDate(pickUp.getLocalDate());
		response.setLocalTime(pickUp.getLocalTime());

		return response;
	}

}
