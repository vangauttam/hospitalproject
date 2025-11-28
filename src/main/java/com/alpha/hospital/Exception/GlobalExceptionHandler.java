package com.alpha.hospital.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.hospital.ResponseStructure;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseStructure<String> PatientNotFoundExhandler(){
		ResponseStructure<String> rs =new ResponseStructure<String>();
			rs.setStatuscode(HttpStatus.NOT_FOUND.value());
			rs.setMessage("Patient id NOT FOUND");
			rs.setData("Patient NOT FOUND");
		return rs;
		
	}
	
	
	@ExceptionHandler(FindPatientByNameException.class)
	public ResponseStructure<String> handleFindPatientByNameException(FindPatientByNameException ex) {
	    
	    ResponseStructure<String> rs = new ResponseStructure<>();
	    rs.setStatuscode(HttpStatus.NOT_FOUND.value());
	    rs.setMessage("Patient name not Found");
	    rs.setData(ex.getMessage());

	    return rs;
	}
	
	
	
	@ExceptionHandler(PatientDeleteConstraintException.class)
	public ResponseEntity<ResponseStructure<String>> handlePatientDeleteConstraint(PatientDeleteConstraintException ex) {
	    ResponseStructure<String> rs = new ResponseStructure<>();
	    rs.setStatuscode(HttpStatus.CONFLICT.value()); // 409
	    rs.setMessage("Deletion failed due to foreign key constraint");
	    rs.setData(ex.getMessage());

	    return new ResponseEntity<>(rs, HttpStatus.CONFLICT);
	}

	
	  @ExceptionHandler(DoctorNotFoundException.class)
	    public ResponseStructure<String> docNotFoundExhandler() {
	        ResponseStructure<String> rs = new ResponseStructure<>();
	        rs.setStatuscode(HttpStatus.NOT_FOUND.value());
	        rs.setMessage("Doctor ID NOT FOUND");
	        rs.setData("Doctor NOT FOUND");
	        return rs;
	    }

	
         
	  
	  @ExceptionHandler(DoctorNotFoundByNameException.class)
	  public ResponseStructure<String> handleDoctorNotFoundByName(DoctorNotFoundByNameException ex) {
	      ResponseStructure<String> rs = new ResponseStructure<>();
	      rs.setStatuscode(HttpStatus.NOT_FOUND.value()); // 404
	      rs.setMessage("Doctor not found with given name");
	      rs.setData(ex.getMessage());
	      return rs;
	  }
	  
	  @ExceptionHandler(DeleteDoctorNotFoundException.class)
	  public ResponseStructure<String> handleDeleteDoctorNotFound(DeleteDoctorNotFoundException ex) {
	      ResponseStructure<String> rs = new ResponseStructure<>();
	      rs.setStatuscode(HttpStatus.NOT_FOUND.value());
	      rs.setMessage("Doctor ID Not Found");
	      rs.setData(ex.getMessage());
	      return rs;
	  }



	
	
	

	
	
	}
	
	

