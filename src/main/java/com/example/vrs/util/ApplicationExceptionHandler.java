package com.example.vrs.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.vrs.exceptions.FailedToUploadException;
import com.example.vrs.exceptions.LocationNotFoundException;
import com.example.vrs.exceptions.ProfilePictureNotFoundException;
import com.example.vrs.exceptions.UserNotFoundException;
import com.example.vrs.exceptions.VehicleListingException;
import com.example.vrs.exceptions.VehicleNotFoundExcepction;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleUserNotFound(UserNotFoundException ex) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "User Not found By the given Id"));
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleFailedToUpload(FailedToUploadException ex) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "Failed to upload the Image"));
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleProfilePictureNotFound(ProfilePictureNotFoundException ex) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "Failed to Find the Image"));
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleVehicleNotFound(VehicleNotFoundExcepction ex) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "Failed to Find the Vehicle"));
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleUsernameNotFound(UsernameNotFoundException ex) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "Failed to Find the User By Name"));
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleLocationNotFound(LocationNotFoundException ex) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "Failed to Find the Location"));
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleVehicleListingNotFound(VehicleListingException ex) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "Failed to Find the Vehicle Listing"));
	}
	

}
