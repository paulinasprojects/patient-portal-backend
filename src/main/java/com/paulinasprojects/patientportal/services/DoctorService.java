package com.paulinasprojects.patientportal.services;

import com.paulinasprojects.patientportal.dtos.DoctorRequestDTO;
import com.paulinasprojects.patientportal.dtos.DoctorResponseDTO;

import java.util.List;

public interface DoctorService {
  List<DoctorResponseDTO> getAllDoctors();
  DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO);
}
