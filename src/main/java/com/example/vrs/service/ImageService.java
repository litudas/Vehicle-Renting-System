package com.example.vrs.service;

import org.springframework.stereotype.Service;

import com.example.vrs.repository.ImageRepository;

@Service
public class ImageService {

	private final ImageRepository imageRepository;

	public ImageService(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}
	
}
