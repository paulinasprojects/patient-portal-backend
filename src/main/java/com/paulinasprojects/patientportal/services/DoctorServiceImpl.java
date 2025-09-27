package com.paulinasprojects.patientportal.services;

import com.paulinasprojects.patientportal.dtos.DoctorRequestDTO;
import com.paulinasprojects.patientportal.dtos.DoctorResponseDTO;
import com.paulinasprojects.patientportal.entities.Doctor;
import com.paulinasprojects.patientportal.entities.Role;
import com.paulinasprojects.patientportal.exceptions.DoctorAlreadyExistsException;
import com.paulinasprojects.patientportal.exceptions.DoctorsNotFoundException;
import com.paulinasprojects.patientportal.mappers.DoctorMapper;
import com.paulinasprojects.patientportal.repositories.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DoctorServiceImpl implements DoctorService {
  private final DoctorRepository doctorRepository;

  @Override
  public List<DoctorResponseDTO> getAllDoctors() {
    List<Doctor> doctors = doctorRepository.findAll();
      if (doctors.isEmpty()) {
        throw new DoctorsNotFoundException("Doctors not found");
      }
    return doctors.stream().map(DoctorMapper::toDto).toList();
  }

  @Override
  public DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO) {
    if (doctorRepository.existsByEmail(doctorRequestDTO.getEmail())) {
      throw  new DoctorAlreadyExistsException("A doctor with this email " + "already exists" + doctorRequestDTO.getEmail());
    }
    var doctor = DoctorMapper.toEntity(doctorRequestDTO);
    doctor.setPassword(doctor.getPassword());
    doctor.setRole(Role.DOCTOR);
    doctorRepository.save(doctor);
    return DoctorMapper.toDto(doctor);
  }
}
