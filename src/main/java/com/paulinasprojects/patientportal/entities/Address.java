package com.paulinasprojects.patientportal.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "street")
  private String street;

  @Column(name = "city")
  private String city;

  @Column(name = "zip")
  private String zip;

  @Column(name = "state")
  private String state;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "patient_id")
  @MapsId
  @ToString.Exclude
  private Patient patient;
}
