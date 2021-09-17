package com.server.TRDN.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class PatientProfileDTO {

  private Long id;
  private String gender;
  private Date dateOfBirth;
  private String phoneNumber;
  private String avatar;
  private String city;
  private String bloodType;

  public void setId(Long id) {
    this.id = id;
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

  public Long getId() {
    return id;
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

  @Override
  public String toString() {
    return "PatientProfileDTO{" +
            "id=" + id +
            ", gender='" + gender + '\'' +
            ", dateOfBirth=" + dateOfBirth +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", avatar='" + avatar + '\'' +
            ", city='" + city + '\'' +
            ", bloodType='" + bloodType + '\'' +
            '}';
  }
}
