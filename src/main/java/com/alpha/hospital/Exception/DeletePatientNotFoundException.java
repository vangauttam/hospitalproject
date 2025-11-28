package com.alpha.hospital.Exception;

public class DeletePatientNotFoundException extends RuntimeException {

    public DeletePatientNotFoundException() {
        super("Patient not found for deletion");
    }

    public DeletePatientNotFoundException(String message) {
        super(message);
    }
}

