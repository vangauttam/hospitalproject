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
	
	public void update(int id ,String newname) {
		Patient p=pr.findById(id).get();
		p.setName(newname);
		pr.save(p);
	}
	public void deletepatient(int id) {
		pr.deleteById(id);
	}
	


}