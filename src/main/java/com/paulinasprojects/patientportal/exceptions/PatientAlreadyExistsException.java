package com.paulinasprojects.patientportal.exceptions;

public class PatientAlreadyExistsException extends RuntimeException {
  public PatientAlreadyExistsException(String message) {
    super(message);
  }
}
