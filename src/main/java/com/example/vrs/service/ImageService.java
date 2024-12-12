package com.example.vrs.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.vrs.entity.Image;
import com.example.vrs.entity.User;
import com.example.vrs.exceptions.FailedToUploadException;
import com.example.vrs.exceptions.UserNotFoundException;
import com.example.vrs.repository.ImageRepository;
import com.example.vrs.repository.UserRepository;

@Service
public class ImageService {

	private final ImageRepository imageRepository;
	private final UserRepository userRepository;

	public ImageService(ImageRepository imageRepository, UserRepository userRepository) {
		super();
		this.imageRepository = imageRepository;
		this.userRepository = userRepository;
	}

	public void uploadUserProfilePicture(int userId, MultipartFile file) {

		Optional<User> optional = userRepository.findById(userId);
		if (optional.isPresent()) {
			Image image = imageRepository.save(this.getImage(file));
			User user = optional.get();
			user.setProfilePicture(image);

			userRepository.save(user);
		} else {

			throw new UserNotFoundException("User not Found");
		}

	}

	private Image getImage(MultipartFile file) {

		Image image = new Image();
		try {
			byte[] imageBytes = file.getBytes();
			image.setContentType(file.getContentType());
			image.setImageBytes(imageBytes);
			return image;

		} catch (Exception e) {

			throw new FailedToUploadException("Failed to upload image");
		}
	}

}
