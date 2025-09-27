package com.paulinasprojects.patientportal.services;

import com.paulinasprojects.patientportal.dtos.PatientRequestDTO;
import com.paulinasprojects.patientportal.dtos.PatientResponseDTO;
import com.paulinasprojects.patientportal.entities.Patient;
import com.paulinasprojects.patientportal.entities.Role;
import com.paulinasprojects.patientportal.exceptions.PatientAlreadyExistsException;
import com.paulinasprojects.patientportal.exceptions.PatientsNotFoundException;
import com.paulinasprojects.patientportal.mappers.PatientMapper;
import com.paulinasprojects.patientportal.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PatientServiceImpl implements PatientService {
  private final PatientRepository patientRepository;

  @Override
  public List<PatientResponseDTO> getAllPatients() {
    List<Patient> patients = patientRepository.findAll();
    if (patients.isEmpty()) {
      throw new PatientsNotFoundException("Patients not found");
    }
    return patients.stream().map(PatientMapper::toDto).toList();
  }

  @Override
  public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
    if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
      throw new PatientAlreadyExistsException("A patient with this email " + "already exists" + patientRequestDTO.getEmail());
    }
    var patient = PatientMapper.toEntity(patientRequestDTO);
    patient.setPassword(patient.getPassword());
    patient.setRole(Role.PATIENT);
    patientRepository.save(patient);
    return PatientMapper.toDto(patient);
  }
}
