package com.server.TRDN.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctor")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = DoctorProfile.class,
        resolver = EntityIdResolver.class)
//@DynamicUpdate(value = true)
public class DoctorProfile implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(max = 50)
  @Column(name = "doctor_name")
  private String name;

  @NotNull
  @Size(max = 50)
  @Column(name = "doctor_surname")
  private String surname;

  @Column(length = 10)
  private String gender;

  @NotNull
  @Column(unique = true, name = "phone_number", length = 15)
  private String phoneNumber;

  @Column(name = "specialization", length = 15)
  private String specialization;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "clinic_id",
          referencedColumnName = "clinic_id",
          nullable = false)        //Owner of the relationship @JoinColumn
  @JsonIdentityReference(alwaysAsId = true)
  private Clinic clinic;

  @Column(name = "avatar", length = 200)
  private String avatar;

  @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
  @JoinColumn(name = "doctor_id", nullable = false, referencedColumnName = "credential_id")
  @JsonBackReference
  private Credentials credential;

  @OneToMany(cascade = CascadeType.ALL,
          fetch = FetchType.LAZY,
          mappedBy = "doctorID")
  @JsonIdentityReference(alwaysAsId = true)
  private Set<Prescription> prescriptions = new HashSet<>();

  //Appointment
  @OneToMany(fetch = FetchType.LAZY,
          cascade =  CascadeType.ALL,
          mappedBy = "doctorID")
  @JsonIdentityReference(alwaysAsId = true)
  private Set<Appointment> appointments = new HashSet<>();

  @NotNull
  private boolean approved;

  public DoctorProfile() {}

  public DoctorProfile(Long id, @NotNull @Size(max = 50) String name, @NotNull @Size(max = 50) String surname, String gender, @NotNull String phoneNumber, String specialization, Clinic clinic, String avatar, Credentials credential, Set<Prescription> prescriptions, Set<Appointment> appointments, @NotNull boolean approved) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.gender = gender;
    this.phoneNumber = phoneNumber;
    this.specialization = specialization;
    this.clinic = clinic;
    this.avatar = avatar;
    this.credential = credential;
    this.prescriptions = prescriptions;
    this.appointments = appointments;
    this.approved = approved;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getGender() {
    return gender;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getSpecialization() {
    return specialization;
  }

  public String getAvatar() {
    return avatar;
  }

  public Credentials getCredential() {
    return credential;
  }

  public void setCredential(Credentials credential) {
    this.credential = credential;
  }

  public Clinic getClinic() {
    return clinic;
  }

  public Set<Prescription> getPrescriptions() {
    return prescriptions;
  }

  public Set<Appointment> getAppointments() {
    return appointments;
  }

  public boolean isApproved() {
    return approved;
  }

  public void setApproved(boolean approved) {
    this.approved = approved;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setSpecialization(String specialization) {
    this.specialization = specialization;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public void setClinic(Clinic clinic) {
    this.clinic = clinic;
  }

  public void setPrescriptions(Set<Prescription> prescriptions) {
    this.prescriptions = prescriptions;
  }

  public void setAppointments(Set<Appointment> appointments) {
    this.appointments = appointments;
  }

}
