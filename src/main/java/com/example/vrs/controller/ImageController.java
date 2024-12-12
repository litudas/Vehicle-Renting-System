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
	public ResponseEntity<SimpleResponseStructure> uploadProfile(@RequestParam ("userId") int userId,
				@RequestParam("file") MultipartFile file ){
		
		imageService.uploadUserProfilePicture(userId,file);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(SimpleResponseStructure.create(HttpStatus.CREATED.value(), "Profile Picture Updated"));
	}
	
	@GetMapping("/find-image-by-id")
	public ResponseEntity<byte[]> findImageById(@RequestParam ("imageId") int imageId){

		Image image=imageService.findImageById(imageId);
		
		return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.valueOf(image.getContentType()))
				.body(image.getImageBytes());
	}
}












