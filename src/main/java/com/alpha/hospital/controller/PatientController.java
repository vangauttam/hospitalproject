package com.alpha.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.hospital.Services.PatientServices;

import com.alpha.hospital.entity.Patient;

@RestController
public class PatientController {
	@Autowired
	private PatientServices ps;
	
	@PostMapping("/savepatient")
	public void patientsave(@RequestBody Patient p) {
		ps.savepatient(p);
	}
}
