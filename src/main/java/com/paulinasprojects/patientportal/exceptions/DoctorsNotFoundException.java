package com.paulinasprojects.patientportal.exceptions;

public class DoctorsNotFoundException extends RuntimeException {
  public DoctorsNotFoundException(String message) {
    super(message);
  }
}
