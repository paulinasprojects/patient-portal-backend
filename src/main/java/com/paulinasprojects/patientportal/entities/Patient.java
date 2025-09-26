package com.paulinasprojects.patientportal.entities;

import jakarta.persistence.*;
import lombok.*;

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
  private Address address;

  @OneToOne(mappedBy = "patient", cascade = CascadeType.REMOVE)
  private Profile profile;
}
