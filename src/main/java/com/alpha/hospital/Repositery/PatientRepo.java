package com.alpha.hospital.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.hospital.entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {
	

}
