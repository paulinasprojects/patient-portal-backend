package com.paulinasprojects.patientportal.exceptions;

public class PatientsNotFoundException extends RuntimeException {
  public PatientsNotFoundException(String message) {
    super(message);
  }
}
