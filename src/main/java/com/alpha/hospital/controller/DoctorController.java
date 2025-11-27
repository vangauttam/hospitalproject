package com.alpha.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PutMapping("/updatedoctor")
	public void update(@RequestParam int id, @RequestParam String newname) {
		ds.update(id, newname);
	}
	@DeleteMapping("/deleteDoctor")
	public void deleteDoctor(@RequestParam int id) {
		ds.deletedoctor(id);
		
	}
	@GetMapping("/findDoctor")
	public Doctor findDoctor(@RequestParam int id) {
		return ds.findDoctor(id);
	}

}
