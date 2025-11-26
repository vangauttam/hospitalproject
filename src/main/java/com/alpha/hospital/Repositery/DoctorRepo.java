package com.alpha.hospital.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.hospital.entity.Doctor;

@Repository

public interface DoctorRepo extends  JpaRepository<Doctor, Integer> {
	

}
