package com.server.TRDN.repository;

import com.server.TRDN.model.PatientProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientProfileRepository extends JpaRepository<PatientProfile, Long> {

  public PatientProfile getPatientProfileByCredential_Email(String email);
}
