package com.paulinasprojects.patientportal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
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

    @OneToOne(mappedBy = "doctor", cascade = CascadeType.REMOVE)
    private DoctorAddress address;

    @OneToOne(mappedBy = "doctor", cascade = CascadeType.REMOVE)
    private DoctorProfile profile;

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
