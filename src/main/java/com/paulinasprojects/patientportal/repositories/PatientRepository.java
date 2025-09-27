package com.paulinasprojects.patientportal.repositories;

import com.paulinasprojects.patientportal.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
  Patient findPatientByName(String patientName);
  boolean existsByEmail(String email);
}
