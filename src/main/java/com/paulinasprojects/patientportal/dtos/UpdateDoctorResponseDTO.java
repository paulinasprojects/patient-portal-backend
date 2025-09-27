package com.paulinasprojects.patientportal.dtos;

import lombok.Data;

@Data
public class UpdateDoctorResponseDTO {
  private String name;
  private String email;
  private String address;
  private String bio;
}
