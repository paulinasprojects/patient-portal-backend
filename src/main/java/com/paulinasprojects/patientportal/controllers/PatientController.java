package com.paulinasprojects.patientportal.controllers;

import com.paulinasprojects.patientportal.dtos.PatientRequestDTO;
import com.paulinasprojects.patientportal.dtos.PatientResponseDTO;
import com.paulinasprojects.patientportal.dtos.UpdatePatientRequestDTO;
import com.paulinasprojects.patientportal.dtos.UpdatePatientResponseDTO;
import com.paulinasprojects.patientportal.services.PatientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class PatientController {
  private final PatientService patientService;

  @GetMapping("/patients")
  public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
    List<PatientResponseDTO> patients = patientService.getAllPatients();
    return ResponseEntity.ok().body(patients);
  }

  @PostMapping("/patients")
  public  ResponseEntity<PatientResponseDTO> createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO) {
    PatientResponseDTO patientResponseDTO = patientService.createPatient(patientRequestDTO);
    return ResponseEntity.ok().body(patientResponseDTO);
  }

  @PutMapping("/patients/{id}")
  public UpdatePatientResponseDTO updatePatient(@PathVariable(name = "id") Long id, @RequestBody UpdatePatientRequestDTO request) {
    return patientService.updatePatient(id, request);
  }

  @DeleteMapping("/patients/{id}")
  public ResponseEntity<Void> deletePatient(@PathVariable(name = "id") Long id) {
    patientService.deletePatient(id);
    return ResponseEntity.noContent().build();
  }
}

