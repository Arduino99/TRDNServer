package com.server.TRDN.repository;

import com.server.TRDN.model.PatientAllergy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientAllergyRepository extends JpaRepository<PatientAllergy, Long> {
}
