package com.example.vrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.vrs.entity.PickUp;

@Repository
public interface PickUpRepository extends JpaRepository<PickUp, Integer>{

}
