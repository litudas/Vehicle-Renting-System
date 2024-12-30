package com.example.vrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.vrs.entity.Drop;

@Repository
public interface DropRepository extends JpaRepository<Drop, Integer>{

}
