package com.paulinasprojects.patientportal.mappers;

import com.paulinasprojects.patientportal.dtos.PatientRequestDTO;
import com.paulinasprojects.patientportal.dtos.PatientResponseDTO;
import com.paulinasprojects.patientportal.entities.Patient;

import java.time.LocalDate;

public interface PatientMapper {
  static PatientResponseDTO toDto(Patient patient) {
    PatientResponseDTO patientDTO = new PatientResponseDTO();
    patientDTO.setId(patient.getId());
    patientDTO.setBio(patient.getBio());
    patientDTO.setName(patient.getName());
    patientDTO.setAddress(patient.getAddress());
    patientDTO.setEmail(patient.getEmail());
    patientDTO.setRole(patient.getRole());
    patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());
    patientDTO.setRegisteredDate(patient.getRegisteredDate().toString());
    return patientDTO;
  }

  static Patient toEntity(PatientRequestDTO patientRequestDTO) {
    Patient patient = new Patient();
    patient.setName(patientRequestDTO.getName());
    patient.setBio(patientRequestDTO.getBio());
    patient.setPassword(patientRequestDTO.getPassword());
    patient.setEmail(patientRequestDTO.getEmail());
    patient.setAddress(patientRequestDTO.getAddress());
    patient.setRole(patientRequestDTO.getRole());
    patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
    if (patientRequestDTO.getRegisteredDate() != null) {
      patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
    } else {
      patient.setRegisteredDate(LocalDate.now());
    }
    return patient;
  }
}
