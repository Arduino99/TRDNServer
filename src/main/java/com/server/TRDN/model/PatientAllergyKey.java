package com.server.TRDN.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class PatientAllergyKey implements Serializable {

  // ===================== Primary Key =====================
  //FOREIGN KEY
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "allergy_id", nullable = false)
  @JsonIdentityReference(alwaysAsId = true)
  private Allergy allergyID;

  //FOREIGN KEY
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "patient_id", nullable = false)
  @JsonIdentityReference(alwaysAsId = true)
  private PatientProfile patientID;
  // =======================================================

  public Allergy getAllergyID() {
    return allergyID;
  }

  public PatientProfile getPatientID() {
    return patientID;
  }
}