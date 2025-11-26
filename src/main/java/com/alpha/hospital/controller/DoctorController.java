package com.alpha.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.hospital.Services.DoctorServices;
import com.alpha.hospital.entity.Doctor;

@RestController
public class DoctorController {
	@Autowired
	private DoctorServices ds;
	
	@PostMapping("/savedoctor")
	public void doctorsave(@RequestBody Doctor d) {
		ds.savedoctor(d);
	}
	

}
