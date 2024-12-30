package com.example.vrs.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FieldErrorExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<List<Map<String, Object>>>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

	 List<Map<String, Object>> ers = ex.getAllErrors().stream()//Stream<Objects>
			 .map(er -> (FieldError) er)//Stream<FieldError>
			 .map(er ->{
				 Map<String, Object> error=new HashMap<String, Object>();
				 error.put("field",er.getField());
				 error.put("rejectedValue",er.getRejectedValue());
				 error.put("message",er.getDefaultMessage());
				 return error;//Stream<map<String,objects>>
				 }).toList();//List<map<String,object>>
	 
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorStructure.create(HttpStatus.BAD_REQUEST.value(), "Invalid Input", ers));
	}
}
