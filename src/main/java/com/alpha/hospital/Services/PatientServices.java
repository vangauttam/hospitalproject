package com.alpha.hospital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.hospital.Repositery.PatientRepo;
import com.alpha.hospital.entity.Patient;

@Service
public class PatientServices {
	@Autowired
	private PatientRepo pr;
	public void savepatient(Patient p) {
		pr.save(p);
	}
}