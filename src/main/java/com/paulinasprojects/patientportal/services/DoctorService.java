package com.paulinasprojects.patientportal.services;

import com.paulinasprojects.patientportal.dtos.DoctorRequestDTO;
import com.paulinasprojects.patientportal.dtos.DoctorResponseDTO;
import com.paulinasprojects.patientportal.dtos.UpdateDoctorRequestDTO;
import com.paulinasprojects.patientportal.dtos.UpdateDoctorResponseDTO;

import java.util.List;

public interface DoctorService {
  List<DoctorResponseDTO> getAllDoctors();
  DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO);
  UpdateDoctorResponseDTO updateDoctor(Long id, UpdateDoctorRequestDTO updateDoctorRequestDTO);
  void deleteDoctor(Long id);
}
