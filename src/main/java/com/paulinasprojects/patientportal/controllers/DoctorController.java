package com.paulinasprojects.patientportal.controllers;

import com.paulinasprojects.patientportal.dtos.DoctorRequestDTO;
import com.paulinasprojects.patientportal.dtos.DoctorResponseDTO;
import com.paulinasprojects.patientportal.dtos.UpdateDoctorRequestDTO;
import com.paulinasprojects.patientportal.dtos.UpdateDoctorResponseDTO;
import com.paulinasprojects.patientportal.services.DoctorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class DoctorController {
  private final DoctorService doctorService;

  @GetMapping("/doctors")
  public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors() {
    List<DoctorResponseDTO> doctors = doctorService.getAllDoctors();
    return  ResponseEntity.ok().body(doctors);
  }

  @PostMapping("/doctors")
  public ResponseEntity<DoctorResponseDTO> createDoctor(@Valid @RequestBody DoctorRequestDTO doctorRequestDTO) {
    DoctorResponseDTO doctorResponseDTO = doctorService.createDoctor(doctorRequestDTO);
    return ResponseEntity.ok().body(doctorResponseDTO);
  }

  @PutMapping("/doctors/{id}")
  public UpdateDoctorResponseDTO updateDoctor(@PathVariable(name = "id") Long id, @RequestBody UpdateDoctorRequestDTO request) {
    return doctorService.updateDoctor(id, request);
  }

  @DeleteMapping("/doctors/{id}")
  public ResponseEntity<Void> deleteDoctor(@PathVariable(name = "id") Long id) {
    doctorService.deleteDoctor(id);
    return ResponseEntity.noContent().build();
  }
}
