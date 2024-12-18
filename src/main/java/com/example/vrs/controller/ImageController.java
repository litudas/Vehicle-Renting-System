package com.example.vrs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.vrs.entity.Image;
import com.example.vrs.service.ImageService;
import com.example.vrs.util.SimpleResponseStructure;

@RestController
public class ImageController {

	private final ImageService imageService;

	public ImageController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping("/upload-profile")
	public ResponseEntity<SimpleResponseStructure> uploadUserProfilePicture(@RequestParam("file") MultipartFile file ){
		
		imageService.uploadUserProfilePicture(file);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(SimpleResponseStructure.create(HttpStatus.CREATED.value(), "Profile Picture Uploaded")); // application/json
	}
	
	@GetMapping("/find-image-by-id")
	public ResponseEntity<byte[]> findImageById(@RequestParam ("image-id") int imageId){

		Image image=imageService.findImageById(imageId);
		
		return ResponseEntity.status(HttpStatus.FOUND).contentType(MediaType.valueOf(image.getContentType())) // image/*
				.body(image.getImageBytes());
	}
}




