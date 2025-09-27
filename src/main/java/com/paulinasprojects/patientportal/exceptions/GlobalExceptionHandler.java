package com.paulinasprojects.patientportal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(PatientsNotFoundException.class)
  public ResponseEntity<String> PatientsNotFoundException(PatientsNotFoundException e) {
    String message = e.getMessage();
    return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(DoctorsNotFoundException.class)
  public ResponseEntity<String> DoctorsNotFondException(DoctorsNotFoundException e) {
    String message = e.getMessage();
    return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(PatientAlreadyExistsException.class)
  public ResponseEntity<String> PatientAlreadyExistException(PatientAlreadyExistsException e) {
    String message = e.getMessage();
    return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(DoctorAlreadyExistsException.class)
  public ResponseEntity<String> DoctorAlreadyExistException(DoctorAlreadyExistsException e) {
    String message = e.getMessage();
    return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
  }
}
