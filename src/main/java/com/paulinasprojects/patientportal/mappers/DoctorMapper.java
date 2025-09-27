package com.paulinasprojects.patientportal.mappers;

import com.paulinasprojects.patientportal.dtos.DoctorRequestDTO;
import com.paulinasprojects.patientportal.dtos.DoctorResponseDTO;
import com.paulinasprojects.patientportal.entities.Doctor;


import java.time.LocalDate;

public interface DoctorMapper {
  static DoctorResponseDTO toDto(Doctor doctor) {
    DoctorResponseDTO doctorDTO = new DoctorResponseDTO();
    doctorDTO.setId(doctor.getId());
    doctorDTO.setBio(doctor.getBio());
    doctorDTO.setSpecialty(doctor.getSpecialty());
    doctorDTO.setName(doctor.getName());
    doctorDTO.setAddress(doctor.getAddress());
    doctorDTO.setEmail(doctor.getEmail());
    doctorDTO.setRole(doctor.getRole());
    doctorDTO.setDateOfBirth(doctor.getDateOfBirth().toString());
    doctorDTO.setRegisteredDate(doctor.getRegisteredDate().toString());
    return doctorDTO;
  }

  static Doctor toEntity(DoctorRequestDTO doctorRequestDTO) {
    Doctor doctor = new Doctor();
    doctor.setName(doctorRequestDTO.getName());
    doctor.setBio(doctorRequestDTO.getBio());
    doctor.setSpecialty(doctorRequestDTO.getSpecialty());
    doctor.setPassword(doctorRequestDTO.getPassword());
    doctor.setEmail(doctorRequestDTO.getEmail());
    doctor.setAddress(doctorRequestDTO.getAddress());
    doctor.setRole(doctorRequestDTO.getRole());
    doctor.setDateOfBirth(LocalDate.parse(doctorRequestDTO.getDateOfBirth()));
    if (doctorRequestDTO.getRegisteredDate() != null) {
      doctor.setRegisteredDate(LocalDate.parse(doctorRequestDTO.getRegisteredDate()));
    } else {
      doctor.setRegisteredDate(LocalDate.now());
    }
    return doctor;
  }
}
