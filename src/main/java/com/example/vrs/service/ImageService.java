package com.example.vrs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.vrs.entity.Image;
import com.example.vrs.entity.User;
import com.example.vrs.entity.Vehicle;
import com.example.vrs.exceptions.FailedToUploadException;
import com.example.vrs.exceptions.ProfilePictureNotFoundException;
import com.example.vrs.exceptions.VehicleNotFoundExcepction;
import com.example.vrs.repository.ImageRepository;
import com.example.vrs.repository.UserRepository;
import com.example.vrs.repository.VehicleRepository;
import com.example.vrs.security.AuthUtil;

@Service
public class ImageService {

	private final ImageRepository imageRepository;
	private final UserRepository userRepository;
	private final AuthUtil authUtil;
	private final VehicleRepository vehicleRepository;

	public ImageService(ImageRepository imageRepository, UserRepository userRepository, AuthUtil authUtil, VehicleRepository vehicleRepository) {
		super();
		this.imageRepository = imageRepository;
		this.userRepository = userRepository;
		this.authUtil = authUtil;
		this.vehicleRepository = vehicleRepository;
	}

	public void uploadUserProfilePicture(MultipartFile file) {

		User user = authUtil.getCurrentUser();
		Image exImage = user.getProfilePicture();

		Image image = imageRepository.save(this.getImage(file));
		user.setProfilePicture(image);
		userRepository.save(user);

		imageRepository.delete(exImage);
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

	public Image findImageById(int imageId) {

		Optional<Image> optional = imageRepository.findById(imageId);
		if (optional.isPresent()) {

			Image image = optional.get();

			return image;
		} else {

			throw new ProfilePictureNotFoundException("Image not Found");
		}

	}

	public void addVehicleImages(List<MultipartFile> files, int vehicleId) {

		Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new VehicleNotFoundExcepction("Failed to upload images"));
		List<Image> images = new ArrayList<Image>();

		for (MultipartFile file : files) {
			images.add(this.getImage(file));
		}
		
		images = imageRepository.saveAll(images);
		
		vehicle.setVehicleImages(images);
		vehicleRepository.save(vehicle);
	}

}
