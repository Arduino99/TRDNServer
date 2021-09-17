package com.server.TRDN.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "appointment")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "appointmentID",
        scope = Long.class)
public class Appointment implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "appointment_id")
  private Long appointmentID;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "patient_id", nullable = false, referencedColumnName = "id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIdentityReference(alwaysAsId = true) // show only id of Patients
  private PatientProfile patientID;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "doctor_id", nullable = false,
          referencedColumnName = "id"
  )
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIdentityReference(alwaysAsId = true)
  private DoctorProfile doctorID;

  @Column(name = "appointment_starts")
  private java.sql.Timestamp appointmentStarts;

  @Column(name = "appointment_ends")
  private java.sql.Timestamp appointmentEnds;

  @Column(name = "notes", length = 200)
  private String notes;

  @Column(name = "approved")
  private boolean approved;

  public Appointment() { }

  public Appointment(Long appointmentID, Timestamp appointmentStarts, Timestamp appointmentEnds, String notes, boolean approved) {
    this.appointmentID = appointmentID;
    this.appointmentStarts = appointmentStarts;
    this.appointmentEnds = appointmentEnds;
    this.notes = notes;
    this.approved = approved;
  }

  public Appointment(Long appointmentID, DoctorProfile doctorID, Timestamp appointmentStarts, Timestamp appointmentEnds, String notes, boolean approved) {
    this.appointmentID = appointmentID;
    this.doctorID = doctorID;
    this.appointmentStarts = appointmentStarts;
    this.appointmentEnds = appointmentEnds;
    this.notes = notes;
    this.approved = approved;
  }

  public Long getAppointmentID() {
    return appointmentID;
  }

  public PatientProfile getPatientID() {
    return patientID;
  }

  public DoctorProfile getDoctorID() {
    return doctorID;
  }

  public Timestamp getAppointmentStarts() {
    return appointmentStarts;
  }

  public Timestamp getAppointmentEnds() {
    return appointmentEnds;
  }

  public String getNotes() {
    return notes;
  }

  public boolean getApproved() {
    return approved;
  }

  public void setPatientID(PatientProfile patientID) {
    this.patientID = patientID;
  }

  public void setDoctorID(DoctorProfile doctorID) {
    this.doctorID = doctorID;
  }

  public void setAppointmentStarts(Timestamp appointmentStarts) {
    this.appointmentStarts = appointmentStarts;
  }

  public void setAppointmentEnds(Timestamp appointmentEnds) {
    this.appointmentEnds = appointmentEnds;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public void setApproved(boolean approved) {
    this.approved = approved;
  }
}
