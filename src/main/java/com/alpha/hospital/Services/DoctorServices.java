package com.alpha.hospital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.hospital.Repositery.DoctorRepo;
import com.alpha.hospital.entity.Doctor;

@Service
public class DoctorServices {
	@Autowired
	private DoctorRepo dr;
	public void savedoctor(Doctor d) {
		dr.save(d);
	
}
}
