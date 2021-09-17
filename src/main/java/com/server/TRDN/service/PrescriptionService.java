package com.server.TRDN.service;

import com.server.TRDN.DTO.PrescriptionDTO;
import com.server.TRDN.mapper.PrescriptionMapper;
import com.server.TRDN.controller.Exceptions.PrescriptionNotFoundException;
import com.server.TRDN.model.Prescription;
import com.server.TRDN.repository.PrescriptionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {
  private final PrescriptionRepository prescriptionRepository;
  private final PrescriptionMapper prescriptionMapper;

  public PrescriptionService(PrescriptionRepository prescriptionRepository, PrescriptionMapper prescriptionMapper) {
    this.prescriptionRepository = prescriptionRepository;
    this.prescriptionMapper = prescriptionMapper;
  }

  public List<Prescription> getAllPrescriptions() {
    return (List<Prescription>) prescriptionRepository.findAll();
  }

  public void deletePrescription(Long id){
    prescriptionRepository.deleteById(id);
  }

  public Prescription getPrescriptionByID(Long id) {
    return prescriptionRepository.findById(id).orElseThrow(() -> new PrescriptionNotFoundException(id));
  }

  public Prescription newPrescription(Prescription prescription){
    return prescriptionRepository.save(prescription);
  }

  public ResponseEntity<Prescription> updatePrescription(PrescriptionDTO newInfo, Long id){

    Prescription ps = prescriptionRepository.findById(id).orElseThrow(
            () -> new PrescriptionNotFoundException(id));

    prescriptionMapper.updatePrescriptionFromDto(newInfo, ps);

    final Prescription updatedPrescription = prescriptionRepository.save(ps);
    return ResponseEntity.ok(updatedPrescription);
  }
}
