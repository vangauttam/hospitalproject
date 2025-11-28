package com.alpha.hospital.Exception;

public class FindPatientByNameException extends RuntimeException {
    public FindPatientByNameException(String msg) {
        super(msg);
    }
}
