package com.paulinasprojects.patientportal.services;

import com.paulinasprojects.patientportal.dtos.PatientRequestDTO;
import com.paulinasprojects.patientportal.dtos.PatientResponseDTO;

import java.util.List;

public interface PatientService {
  List<PatientResponseDTO> getAllPatients();
  PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO);
}
