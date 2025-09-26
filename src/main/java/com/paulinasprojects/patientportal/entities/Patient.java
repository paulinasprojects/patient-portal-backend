package com.paulinasprojects.patientportal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
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

  @OneToOne(mappedBy = "patient", cascade = CascadeType.REMOVE)
  private PatientAddress address;

  @OneToOne(mappedBy = "patient", cascade = CascadeType.REMOVE)
  private PatientProfile profile;

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
