package com.alpha.hospital.Exception;

public class UpdateDoctorNotFoundException extends RuntimeException {

    public UpdateDoctorNotFoundException() {
        super("Doctor not found for update");
    }

    public UpdateDoctorNotFoundException(String message) {
        super(message);
    }
}


