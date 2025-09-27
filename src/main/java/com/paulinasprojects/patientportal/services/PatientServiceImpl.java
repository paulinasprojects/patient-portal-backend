package com.paulinasprojects.patientportal.services;

import com.paulinasprojects.patientportal.dtos.PatientRequestDTO;
import com.paulinasprojects.patientportal.dtos.PatientResponseDTO;
import com.paulinasprojects.patientportal.dtos.UpdatePatientRequestDTO;
import com.paulinasprojects.patientportal.dtos.UpdatePatientResponseDTO;
import com.paulinasprojects.patientportal.entities.Patient;
import com.paulinasprojects.patientportal.entities.Role;
import com.paulinasprojects.patientportal.exceptions.PatientAlreadyExistsException;
import com.paulinasprojects.patientportal.exceptions.PatientNotFoundException;
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
  private final PatientMapper patientMapper;

  @Override
  public List<PatientResponseDTO> getAllPatients() {
    List<Patient> patients = patientRepository.findAll();
    if (patients.isEmpty()) {
      throw new PatientsNotFoundException("Patients not found");
    }
    return patients.stream().map(patientMapper::toDto).toList();
  }

  @Override
  public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
    if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
      throw new PatientAlreadyExistsException("A patient with this email " + "already exists" + patientRequestDTO.getEmail());
    }
    var patient = patientMapper.toEntity(patientRequestDTO);
    patient.setPassword(patient.getPassword());
    patient.setRole(Role.PATIENT);
    patientRepository.save(patient);
    return patientMapper.toDto(patient);
  }

  @Override
  public UpdatePatientResponseDTO updatePatient(Long id, UpdatePatientRequestDTO updatePatientRequestDTO) {
    Patient patient = patientRepository.findById(id).orElseThrow(
            () -> new PatientNotFoundException("Patient not found with ID: " + id));

    patientMapper.updateEntityFromDto(updatePatientRequestDTO, patient);
    Patient updatedPatient = patientRepository.save(patient);
    return patientMapper.toUpdateDto(updatedPatient);
  }

  @Override
  public void deletePatient(Long id) {
    var patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
    patientRepository.delete(patient);
  }


}
