package com.paulinasprojects.patientportal.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.paulinasprojects.patientportal.entities.Role;

@Data
@AllArgsConstructor
public class DoctorRequestDTO {

  @NotBlank(message = "Name is required")
  @Size(max = 100, message = "Name cannot exceed 100 characters")
  private String name;

  @NotBlank(message = "Email is required")
  @Email(message = "Email must be valid")
  private String email;

  @NotBlank(message = "Password is required")
  @Size(min = 6, max = 25, message = "Password must be between 6 and 25 characters long.")
  private String password;

  @NotBlank(message = "Specialty is required")
  private String specialty;

  private String bio;

  private String address;

  private String dateOfBirth;

  private String registeredDate;

  private Role role;


}
