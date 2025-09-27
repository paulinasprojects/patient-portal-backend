package com.paulinasprojects.patientportal.services;

import com.paulinasprojects.patientportal.dtos.PatientRequestDTO;
import com.paulinasprojects.patientportal.dtos.PatientResponseDTO;
import com.paulinasprojects.patientportal.dtos.UpdatePatientRequestDTO;
import com.paulinasprojects.patientportal.dtos.UpdatePatientResponseDTO;

import java.util.List;

public interface PatientService {
  List<PatientResponseDTO> getAllPatients();
  PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO);
  UpdatePatientResponseDTO updatePatient(Long id, UpdatePatientRequestDTO updatePatientRequestDTO);
  void deletePatient(Long id);
}
