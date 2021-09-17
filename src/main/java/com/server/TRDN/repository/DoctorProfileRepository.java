package com.server.TRDN.repository;

import com.server.TRDN.model.DoctorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorProfileRepository extends JpaRepository<DoctorProfile, Long>  {

  public List<DoctorProfile> findByApprovedIsFalse();

  public List<DoctorProfile> findByApprovedIsTrue();

  public List<DoctorProfile> findDoctorProfilesBySpecializationAndApprovedIsTrue(String specialization);

  public List<DoctorProfile> findDoctorProfilesByClinic_CityAndSpecializationAndApprovedIsTrue(String city, String specialization);

  public DoctorProfile findDoctorProfileByCredential_Email(String email);



}
