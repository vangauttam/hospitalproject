package com.alpha.hospital.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.hospital.ResponseStructure;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseStructure<String> stuNotFoundExhandler(){
		ResponseStructure<String> rs =new ResponseStructure<String>();
			rs.setStatuscode(HttpStatus.NOT_FOUND.value());
			rs.setMessage("Patient NOT FOUND");
			rs.setData("Patient NOT FOUND");
		return rs;
		
	}

}
