package com.paulinasprojects.patientportal.entities;

import jakarta.persistence.*;
import lombok.*;

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
  }
