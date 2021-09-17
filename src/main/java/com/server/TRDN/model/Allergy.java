package com.server.TRDN.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "allergy")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "name", scope = Long.class)
public class Allergy implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "allergy_id")
  private Long id;

  @Column(name = "allergy_name", length = 50)
  private String name;

  @OneToMany(cascade = CascadeType.ALL,
          fetch = FetchType.LAZY,
          mappedBy = "pt.allergyID")
//  @JsonManagedReference
  private Set<PatientAllergy> patientAllergy = new HashSet<>();

  public Allergy() {}

  public Allergy(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Set<PatientAllergy> getPatientAllergy() {
    return patientAllergy;
  }
}
