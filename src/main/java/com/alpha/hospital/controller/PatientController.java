package com.alpha.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.hospital.ResponseStructure;
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
	
	
	@PutMapping("/updatepatient")
	public ResponseStructure<Patient> update(@RequestParam int id, @RequestParam String newname) {
	    return ps.updatePatient(id, newname);
	}
	

	@DeleteMapping("/deletePatient")
	public ResponseStructure<String> deletePatient(@RequestParam int id) {
	    ps.deletePatient(id);
	    ResponseStructure<String> rs = new ResponseStructure<>();
	    rs.setStatuscode(200);
	    rs.setMessage("Patient deleted successfully");
	    rs.setData("Deleted Patient ID: " + id);
	    return rs;
	}



	@GetMapping("/findPatient")
	public ResponseStructure<Patient> findPatient(@RequestParam int id) {
		return ps.findPatient(id);
	}

	@GetMapping("/findPatientByName")
	public ResponseStructure<Patient> findPatientByName(@RequestParam String name) {
	    return ps.findPatientByName(name);
	}

	
	


}
