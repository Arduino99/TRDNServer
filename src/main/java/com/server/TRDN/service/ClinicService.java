package com.server.TRDN.service;

import com.server.TRDN.DTO.ClinicDTO;
import com.server.TRDN.mapper.ClinicMapper;
import com.server.TRDN.controller.Exceptions.ClinicNotFoundException;
import com.server.TRDN.model.Clinic;
import com.server.TRDN.repository.ClinicRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService {
  private final ClinicRepository clinicRepository;
  private final ClinicMapper clinicMapper;

  public ClinicService(ClinicRepository clinicRepository, ClinicMapper clinicMapper) {
    this.clinicRepository = clinicRepository;
    this.clinicMapper = clinicMapper;
  }

  public List<Clinic> getAllClinics() {
    return (List<Clinic>) clinicRepository.findAll();
  }

  public Clinic newClinic(Clinic clinic){
    return clinicRepository.save(clinic);
  }

  public void deleteClinicById(Long id){
    clinicRepository.deleteById(id);
  }

  public Clinic getClinicByID(Long id) {
    return clinicRepository.findById(id).orElseThrow(() -> new ClinicNotFoundException(id));
  }

  public ResponseEntity<Clinic> updateClinic(ClinicDTO dto, Long id){
    Clinic clinic = clinicRepository.findById(id).orElseThrow(
            () -> new ClinicNotFoundException(id));

    clinicMapper.updateClinicFromDto(dto, clinic);

    final Clinic updatedClinic = clinicRepository.save(clinic);
    return ResponseEntity.ok(updatedClinic);
  }

}
