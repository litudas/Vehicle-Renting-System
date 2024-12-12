package com.example.vrs.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.vrs.exceptions.FailedToUploadException;
import com.example.vrs.exceptions.UserNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotFound(UserNotFoundException ex) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "User Not found By the given Id"));
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleFailedToUpload(FailedToUploadException ex) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "Failed to upload the Image"));
	}

}
