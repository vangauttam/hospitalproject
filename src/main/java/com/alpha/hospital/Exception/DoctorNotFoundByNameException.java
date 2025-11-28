package com.alpha.hospital.Exception;

public class DoctorNotFoundByNameException extends RuntimeException {

    public DoctorNotFoundByNameException(String message) {
        super(message);
    }
}
