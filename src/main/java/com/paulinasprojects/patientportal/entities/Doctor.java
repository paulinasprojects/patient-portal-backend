package com.paulinasprojects.patientportal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctors")
  public class Doctor {

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

    @Column(name = "specialty")
    private String specialty;

    @Column(name = "bio")
    private String bio;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

  @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "registered_date")
    private LocalDate registeredDate;

    @ManyToMany
    @JoinTable(
            name = "doctor_patients",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private Set<Patient> patients = new HashSet<>();

    public void addPatient(Patient patient) {
      patients.add(patient);
      patient.getDoctors().add(this);
    }

    public void removePatient(Patient patient) {
      patients.remove(patient);
      patient.getDoctors().remove(this);
    }
  }
