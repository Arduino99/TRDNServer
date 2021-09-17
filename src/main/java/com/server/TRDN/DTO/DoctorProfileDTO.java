package com.server.TRDN.DTO;

import com.server.TRDN.model.Clinic;
import lombok.Data;

@Data
public class DoctorProfileDTO {

  private Long id;
  private String gender;
  private String phoneNumber;
  private String specialization;
  private String avatar;
  private Clinic clinic;
  private Boolean approved;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getSpecialization() {
    return specialization;
  }

  public void setSpecialization(String specialization) {
    this.specialization = specialization;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public Clinic getClinic() {
    return clinic;
  }

  public void setClinic(Clinic clinic) {
    this.clinic = clinic;
  }

  public Boolean getApproved() {
    return approved;
  }

  public void setApproved(Boolean approved) {
    this.approved = approved;
  }

  @Override
  public String toString() {
    return "DoctorProfileDTO{" +
            "id=" + id +
            ", gender='" + gender + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", specialization='" + specialization + '\'' +
            ", avatar='" + avatar + '\'' +
            '}';
  }
}
