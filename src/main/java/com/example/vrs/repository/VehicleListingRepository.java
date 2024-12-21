package com.example.vrs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.vrs.entity.VehicleListing;

@Repository
public interface VehicleListingRepository extends JpaRepository<VehicleListing, Integer> {

	@Query("SELECT v FROM VehicleListing v WHERE v.vehicle.id = :vehicleId")
	List<VehicleListing> findAllByVehicleId(int vehicleId);

	
}

