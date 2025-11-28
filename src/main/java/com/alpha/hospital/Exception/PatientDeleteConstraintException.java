package com.alpha.hospital.Exception;

public class PatientDeleteConstraintException extends RuntimeException {

    public PatientDeleteConstraintException() {
        super("Cannot delete patient because related records exist");
    }

    public PatientDeleteConstraintException(String message) {
        super(message);
    }
}

