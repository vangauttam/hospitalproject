package com.alpha.hospital.Repositery;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.hospital.entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {
	
	   Optional<Patient> findByName(String name);
	   
}
