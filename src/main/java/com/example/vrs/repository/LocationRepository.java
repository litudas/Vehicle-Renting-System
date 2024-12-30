package com.example.vrs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.vrs.entity.Location;
import com.example.vrs.entity.VehicleListing;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

	List<Location> findAllByVehicleListings(VehicleListing vehicleListing);
	
}
