package com.server.TRDN.DTO;

import java.sql.Timestamp;

public class AppointmentDTO {

  private Long appointmentID;
  private java.sql.Timestamp appointmentStarts;
  private java.sql.Timestamp appointmentEnds;
  private String notes;
  private boolean approved;

  public Long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(Long appointmentID) {
    this.appointmentID = appointmentID;
  }

  public Timestamp getAppointmentStarts() {
    return appointmentStarts;
  }

  public void setAppointmentStarts(Timestamp appointmentStarts) {
    this.appointmentStarts = appointmentStarts;
  }

  public Timestamp getAppointmentEnds() {
    return appointmentEnds;
  }

  public void setAppointmentEnds(Timestamp appointmentEnds) {
    this.appointmentEnds = appointmentEnds;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public boolean isApproved() {
    return approved;
  }

  public void setApproved(boolean approved) {
    this.approved = approved;
  }
}
