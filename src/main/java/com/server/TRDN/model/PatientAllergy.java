package com.server.TRDN.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "patient_allergy")
public class PatientAllergy{

  @EmbeddedId
  PatientAllergyKey pt;

  public PatientAllergy() {}

  public PatientAllergyKey getPt() {
    return pt;
  }
}