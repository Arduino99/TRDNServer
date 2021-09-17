package com.server.TRDN.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "prescriptions")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Prescription implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "treatment_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "patient_id", nullable = false, referencedColumnName = "id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIdentityReference(alwaysAsId = true) // show only id of Patients
  private PatientProfile patientID;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "doctor_id", nullable = false, referencedColumnName = "id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIdentityReference(alwaysAsId = true) // show only id of Doctors
  private DoctorProfile doctorID;

  @Column(name = "treatment_drug", length = 150)
  private String drug;

  @Temporal(TemporalType.DATE)
  @Column(name = "treatment_date")
  private Date date;

  @Column(name = "notes", length = 500)
  private String notes;

  public Prescription() { }

  public Prescription(Long id, String drug, Date date, String notes) {
    this.id = id;
    this.drug = drug;
    this.date = date;
    this.notes = notes;
  }

  public Prescription(PatientProfile patientID, DoctorProfile doctorID, String drug, Date date, String notes) {
    this.patientID = patientID;
    this.doctorID = doctorID;
    this.drug = drug;
    this.date = date;
    this.notes = notes;
  }

  public Long getId() {
    return id;
  }

  public PatientProfile getPatientID() {
    return patientID;
  }

  public DoctorProfile getDoctorID() {
    return doctorID;
  }

  public String getDrug() {
    return drug;
  }

  public Date getDate() {
    return date;
  }

  public String getNotes() {
    return notes;
  }

  public void setPatientID(PatientProfile patientID) {
    this.patientID = patientID;
  }

  public void setDoctorID(DoctorProfile doctorID) {
    this.doctorID = doctorID;
  }

  public void setDrug(String drug) {
    this.drug = drug;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}
