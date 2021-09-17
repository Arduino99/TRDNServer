package com.server.TRDN.DTO;

import com.server.TRDN.model.DoctorProfile;
import com.server.TRDN.model.PatientProfile;

import java.util.Date;

public class PrescriptionDTO {

  private Long id;

  private PatientProfile patientID;
  private DoctorProfile doctorID;
  private String drug;
  private Date date;
  private String notes;

  public Long getId() {
    return id;
  }

  public PatientProfile getPatientID() {
    return patientID;
  }

  public void setPatientID(PatientProfile patientID) {
    this.patientID = patientID;
  }

  public DoctorProfile getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(DoctorProfile doctorID) {
    this.doctorID = doctorID;
  }

  public String getDrug() {
    return drug;
  }

  public void setDrug(String drug) {
    this.drug = drug;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}
