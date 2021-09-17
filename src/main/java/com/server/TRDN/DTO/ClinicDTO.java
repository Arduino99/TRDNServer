package com.server.TRDN.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClinicDTO implements Serializable {

  private Long clinic_id;
  private String name;
  private String city;
  private String address;
  private String postcode;

  public Long getClinic_id() {
    return clinic_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  @Override
  public String toString() {
    return "ClinicDTO{" +
            "clinic_id=" + clinic_id +
            ", name='" + name + '\'' +
            ", city='" + city + '\'' +
            ", address='" + address + '\'' +
            ", postcode='" + postcode + '\'' +
            '}';
  }
}
