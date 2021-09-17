package com.server.TRDN.service;

import com.server.TRDN.model.PatientAllergy;
import com.server.TRDN.repository.AllergyRepository;
import com.server.TRDN.repository.PatientAllergyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllergyService {
  private final AllergyRepository allergyRepository;
  private final PatientAllergyRepository patientAllergyRepository;

  public AllergyService(AllergyRepository allergyRepository, PatientAllergyRepository patientAllergyRepository) {
    this.allergyRepository = allergyRepository;
    this.patientAllergyRepository = patientAllergyRepository;
  }

  public List<PatientAllergy> getAllPatientAllergies() {
    return (List<PatientAllergy>) patientAllergyRepository.findAll();
  }
}
