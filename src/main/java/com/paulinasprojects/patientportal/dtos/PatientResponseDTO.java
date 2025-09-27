package com.paulinasprojects.patientportal.dtos;
import com.paulinasprojects.patientportal.entities.Role;
import lombok.Data;



@Data
public class PatientResponseDTO {
  private Long id;
  private String name;
  private String email;
  private String address;
  private String dateOfBirth;
  private String registeredDate;
  private String bio;
  private Role role;
}
