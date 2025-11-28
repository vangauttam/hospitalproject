package com.alpha.hospital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.hospital.ResponseStructure;
import com.alpha.hospital.Exception.DeleteDoctorNotFoundException;
import com.alpha.hospital.Exception.DoctorNotFoundByNameException;
import com.alpha.hospital.Exception.DoctorNotFoundException;

import com.alpha.hospital.Exception.UpdateDoctorNotFoundException;

import com.alpha.hospital.Repositery.DoctorRepo;
import com.alpha.hospital.entity.Doctor;


@Service
public class DoctorServices {
	@Autowired
	private DoctorRepo dr;
	public void savedoctor(Doctor d) {
		dr.save(d);
	
}
	

	

	
	
	
	 public ResponseStructure<Doctor> findDoctor(int id) {
	        Doctor d = dr.findById(id).orElseThrow(DoctorNotFoundException::new);

	        ResponseStructure<Doctor> rs = new ResponseStructure<>();
	        rs.setStatuscode(HttpStatus.OK.value());
	        rs.setMessage("Doctor with ID " + id + " FOUND");
	        rs.setData(d);

	        return rs;
	    }
	 
	 
	 public ResponseStructure<Doctor> findDoctorByName(String name) {

		    Doctor d = dr.findByName(name).orElseThrow(() -> new DoctorNotFoundByNameException("Doctor with name '" + name + "' does not exist"));

		    ResponseStructure<Doctor> rs = new ResponseStructure<>();
		    rs.setStatuscode(HttpStatus.OK.value());
		    rs.setMessage("Doctor found");
		    rs.setData(d);

		    return rs;
		}
	 
	 
	 public ResponseStructure<Doctor> updateDoctor(int id, String newName) {

		    Doctor existingDoctor = dr.findById(id).orElseThrow(() -> new UpdateDoctorNotFoundException("Doctor with id " + id + " not found"));
		    existingDoctor.setName(newName);
		    dr.save(existingDoctor);
		    ResponseStructure<Doctor> rs = new ResponseStructure<>();
		    rs.setStatuscode(HttpStatus.OK.value());
		    rs.setMessage("Doctor updated successfully");
		    rs.setData(existingDoctor);

		    return rs;
		}

	 
	 
	   public ResponseStructure<String> deleteDoctor(int id) {
		   
	        Doctor d = dr.findById(id).orElseThrow(() -> new DeleteDoctorNotFoundException("Doctor with id " + id + " not found"));
            dr.delete(d);
            ResponseStructure<String> rs = new ResponseStructure<>();
	        rs.setStatuscode(HttpStatus.OK.value());
	        rs.setMessage("Doctor deleted successfully");
	        rs.setData("Deleted Doctor ID = " + id);

	        return rs;
	    }


	 
	 


}
