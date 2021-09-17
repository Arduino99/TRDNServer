package com.server.TRDN.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clinic")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="clinic_id", resolver = EntityIdResolver.class, scope=Clinic.class)
public class Clinic implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long clinic_id;

  @Column(name = "clinic_name", length = 100)
  private String name;

  @Column(name = "city", length = 50)
  private String city;

  @Column(name = "address", length = 100)
  private String address;

  @Column(name = "postcode", length = 100)
  private String postcode;

  @OneToMany(fetch = FetchType.LAZY,
          cascade =  CascadeType.ALL,
          mappedBy = "clinic")
  private Set<DoctorProfile> DoctorProfile = new HashSet<>();

  public Clinic() { }

  public Clinic(Long clinic_id, String name, String city, String address, String postcode) {
    this.clinic_id = clinic_id;
    this.name = name;
    this.city = city;
    this.address = address;
    this.postcode = postcode;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public Long getClinic_id() {
    return clinic_id;
  }

  public String getName() {
    return name;
  }

  public String getCity() {
    return city;
  }

  public String getAddress() {
    return address;
  }

  public String getPostcode() {
    return postcode;
  }

}
