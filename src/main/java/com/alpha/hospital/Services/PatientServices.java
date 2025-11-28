package com.alpha.hospital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.hospital.ResponseStructure;
import com.alpha.hospital.Exception.PatientNotFoundException;

import com.alpha.hospital.Exception.UpdatePatientNotFoundException;
import com.alpha.hospital.Exception.DeletePatientNotFoundException;

import com.alpha.hospital.Repositery.PatientRepo;
import com.alpha.hospital.entity.Patient;
import com.alpha.hospital.Exception.FindPatientByNameException;
import com.alpha.hospital.Exception.PatientDeleteConstraintException;

import org.springframework.dao.DataIntegrityViolationException;

@Service
public class PatientServices {
	@Autowired
	private PatientRepo pr;
	public void savepatient(Patient p) {
		pr.save(p);
	}
	
	
	public ResponseStructure<Patient> findPatient(int id){
		Patient p=pr.findById(id).orElseThrow(() -> new PatientNotFoundException());
	ResponseStructure<Patient> rs =new ResponseStructure<Patient>();
		
			rs.setStatuscode(HttpStatus.FOUND.value());
			rs.setMessage("Student with id " +id + " FOUND");
			rs.setData(p);

	    return rs;

}

	    
	    
	public ResponseStructure<Patient> findPatientByName(String name) {

	    Patient p = pr.findByName(name).orElseThrow(() -> new FindPatientByNameException( "Patient with name '" + name + "' not found"));
	    ResponseStructure<Patient> rs = new ResponseStructure<>();
	    rs.setStatuscode(HttpStatus.OK.value());
	    rs.setMessage("Patient with name '" + name + "' found");
	    rs.setData(p);

	    return rs;
	}

	
	
	
	
	public ResponseStructure<Patient> updatePatient(int id, String newName) {

	   
	    Patient existingPatient = pr.findById(id).orElseThrow(() -> new UpdatePatientNotFoundException("Patient with id " + id + " not found"));
	    existingPatient.setName(newName);
	    pr.save(existingPatient);
	    ResponseStructure<Patient> rs = new ResponseStructure<>();
	    rs.setStatuscode(HttpStatus.OK.value());
	    rs.setMessage("Patient updated successfully");
	    rs.setData(existingPatient);

	    return rs;
	}

	
	



	public void deletePatient(int id) {
	    Patient existingPatient = pr.findById(id).orElseThrow(() -> new DeletePatientNotFoundException("Patient with id " + id + " not found"));

	    try {
	        pr.deleteById(id);
	    } catch (DataIntegrityViolationException e) {
	        throw new PatientDeleteConstraintException("Cannot delete patient with id " + id + " as it is referenced by other records");
	    }
	}

	
	



}