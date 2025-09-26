package com.paulinasprojects.patientportal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class Patient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "address")
  private String address;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "date_of_birth")
  private LocalDate dateOfBirth;

  @Column(name = "registered_date")
  private LocalDate registeredDate;

  @Column(name = "bio")
  private String bio;

  @ManyToMany(mappedBy = "patients")
  private Set<Doctor> doctors = new HashSet<>();

  public void addDoctor(Doctor doctor) {
    doctors.add(doctor);
    doctor.getPatients().add(this);
  }

  public void removeDoctor(Doctor doctor) {
    doctors.remove(doctor);
    doctor.getPatients().remove(this);
  }
}
