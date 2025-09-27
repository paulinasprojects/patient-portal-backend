package com.paulinasprojects.patientportal.exceptions;

public class DoctorNotFoundException extends RuntimeException {
  public DoctorNotFoundException(String message) {
    super(message);
  }
}
