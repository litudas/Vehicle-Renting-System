package com.example.vrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vrs.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
