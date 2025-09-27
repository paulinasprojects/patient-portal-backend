package com.paulinasprojects.patientportal.repositories;

import com.paulinasprojects.patientportal.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
  Doctor findDoctorByName(String doctorName);

  boolean existsByEmail(String email);
}
