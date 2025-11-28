package com.alpha.hospital.Exception;

public class DeleteDoctorNotFoundException extends RuntimeException {

    public DeleteDoctorNotFoundException() {
        super("Doctor not found for deletion");
    }

    public DeleteDoctorNotFoundException(String message) {
        super(message);
    }
}
