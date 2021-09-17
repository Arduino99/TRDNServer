package com.server.TRDN.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = PatientProfile.class,
        resolver = EntityIdResolver.class)
public class PatientProfile implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(max = 50)
  @Column(name = "patient_name")
  private String name;

  @NotNull
  @Size(max = 50)
  @Column(name = "patient_surname")
  private String surname;

  @Column(length = 10)
  private String gender;

  @Temporal(TemporalType.DATE)
  @Column(name = "dob")
  private Date dateOfBirth;

  @Column(name = "phone_number", length = 15)
  private String phoneNumber;

  @Column(length = 200)
  private String avatar;

  @Column(length = 50)
  private String city;

  @Column(name= "blood_type", length = 2)
  private String bloodType;

  @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
  @JoinColumn(name = "patient_id", nullable = false, referencedColumnName = "credential_id")
  @JsonBackReference
  private Credentials credential;

  //Prescription
  @OneToMany(cascade = CascadeType.ALL,
          fetch = FetchType.LAZY,
          mappedBy = "patientID")
  @JsonIdentityReference(alwaysAsId = true)
  private Set<Prescription> prescriptions = new HashSet<>();


  @OneToMany(fetch = FetchType.LAZY,
          cascade =  CascadeType.ALL,
          mappedBy = "patientID")
  @JsonIdentityReference(alwaysAsId = true)
  private Set<Appointment> appointments = new HashSet<>();

  @OneToMany(fetch = FetchType.LAZY,
          cascade =  CascadeType.ALL,
          mappedBy = "pt.patientID")
  private Set<PatientAllergy> patientAllergy = new HashSet<>();

  public PatientProfile() { }

  public PatientProfile(Long id, @NotNull @Size(max = 50) String name, @NotNull @Size(max = 50) String surname, String gender, Date dateOfBirth, String phoneNumber, String avatar, String city, String bloodType, Credentials credential, Set<Prescription> prescriptions, Set<Appointment> appointments, Set<PatientAllergy> patientAllergy) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.phoneNumber = phoneNumber;
    this.avatar = avatar;
    this.city = city;
    this.bloodType = bloodType;
    this.credential = credential;
    this.prescriptions = prescriptions;
    this.appointments = appointments;
    this.patientAllergy = patientAllergy;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getGender() {
    return gender;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getAvatar() {
    return avatar;
  }

  public String getCity() {
    return city;
  }

  public String getBloodType() {
    return bloodType;
  }

  public Credentials getCredential() {
    return credential;
  }

  public Set<Prescription> getPrescriptions() {
    return prescriptions;
  }

  public Set<Appointment> getAppointments() {
    return appointments;
  }

  public Set<PatientAllergy> getPatientAllergy() {
    return patientAllergy;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setBloodType(String bloodType) {
    this.bloodType = bloodType;
  }

  public void setCredential(Credentials credential) {
    this.credential = credential;
  }

  public void setPrescriptions(Set<Prescription> prescriptions) {
    this.prescriptions = prescriptions;
  }

  public void setAppointments(Set<Appointment> appointments) {
    this.appointments = appointments;
  }

  public void setPatientAllergy(Set<PatientAllergy> patientAllergy) {
    this.patientAllergy = patientAllergy;
  }
}
