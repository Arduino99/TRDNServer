package com.server.TRDN.service;

import com.server.TRDN.DTO.PatientProfileDTO;
import com.server.TRDN.mapper.PatientProfileMapper;
import com.server.TRDN.controller.Exceptions.PatientNotFoundException;
import com.server.TRDN.model.PatientProfile;
import com.server.TRDN.repository.PatientProfileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
  private final PatientProfileRepository patientProfileRepository;
  private final PatientProfileMapper patientProfileMapper;

  public PatientService(PatientProfileRepository patientProfileRepository, PatientProfileMapper patientProfileMapper) {
    this.patientProfileRepository = patientProfileRepository;
    this.patientProfileMapper = patientProfileMapper;
  }


  public List<PatientProfile> getAllPatientProfiles() {
    return (List<PatientProfile>) patientProfileRepository.findAll();
  }


  public ResponseEntity<PatientProfile> updatePatientProfile(PatientProfileDTO newInfo, long id){
    PatientProfile patientProfile = patientProfileRepository.findById(id).orElseThrow(
            () -> new PatientNotFoundException(id));

    patientProfileMapper.updatePatientProfileFromDto(newInfo, patientProfile);

    final PatientProfile updatedPatient = patientProfileRepository.save(patientProfile);
    return ResponseEntity.ok(updatedPatient);
  }

  public String getPatientName(String email){
    return patientProfileRepository.getPatientProfileByCredential_Email(email).getName();
  }

  public void deletePatient(Long id){
    patientProfileRepository.deleteById(id);
  }


}
