package com.example.vrs.mapper;

import org.springframework.stereotype.Component;

import com.example.vrs.entity.Drop;
import com.example.vrs.requestdto.BookingRequest;
import com.example.vrs.responsedto.DropResponse;

@Component
public class DropMapper {

	public Drop mapToDrop(BookingRequest request) {

		Drop drop = new Drop();

		drop.setLocalDate(request.getDropDate());
		drop.setLocalTime(request.getDropTime());

		return drop;

	}

	public DropResponse mapToDropResponse(Drop drop) {

		DropResponse response = new DropResponse();
		
		response.setDropId(drop.getDropId());
		response.setLocalDate(drop.getLocalDate());
		response.setLocalTime(drop.getLocalTime());

		return response;
	}
}
