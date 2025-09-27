package com.paulinasprojects.patientportal.exceptions;

public class DoctorAlreadyExistsException extends RuntimeException {
  public DoctorAlreadyExistsException(String message) {
    super(message);
  }
}
