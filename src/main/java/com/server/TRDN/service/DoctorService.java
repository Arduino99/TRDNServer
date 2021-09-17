package com.server.TRDN.service;

import com.server.TRDN.DTO.DoctorProfileDTO;
import com.server.TRDN.controller.Exceptions.DoctorNotFoundException;
import com.server.TRDN.mapper.DoctorProfileMapper;
import com.server.TRDN.model.DoctorProfile;
import com.server.TRDN.repository.DoctorProfileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

  private final DoctorProfileRepository doctorProfileRepository;
  private final DoctorProfileMapper doctorProfileMapper;

//  private DoctorProfileMapper mapper = Mappers.getMapper(DoctorProfileMapper.class);

  public DoctorService(DoctorProfileRepository doctorProfileRepository, DoctorProfileMapper doctorProfileMapper) {
    this.doctorProfileRepository = doctorProfileRepository;
    this.doctorProfileMapper = doctorProfileMapper;
  }

  public List<DoctorProfile> getAllDoctors() {
    return (List<DoctorProfile>) doctorProfileRepository.findAll();
  }

  public DoctorProfile getDoctorProfileByID(Long id) {
    return doctorProfileRepository.findById(id).orElseThrow(() -> new DoctorNotFoundException(id));
  }

  public DoctorProfile approveDoctor(Long id){
    return doctorProfileRepository.findById(id)
            .map( doctor -> {
              doctor.setApproved(true);
              return doctorProfileRepository.save(doctor);
            }).orElseThrow(RuntimeException::new);
  }

  public void deleteDoctorProfile(Long id){
    doctorProfileRepository.deleteById(id);
  }

  public List<DoctorProfile> getDoctorsApproved() {
    return doctorProfileRepository.findByApprovedIsTrue();
  }

  public List<DoctorProfile> getDoctorsNotApproved() {
    return doctorProfileRepository.findByApprovedIsFalse();
  }

  public List<DoctorProfile> getDoctorsBySpecialization(String specialization) {
    return doctorProfileRepository.findDoctorProfilesBySpecializationAndApprovedIsTrue(specialization);
  }

  public List<DoctorProfile> getDoctorsByCityAndSpecialization(String city, String specialization){
    return doctorProfileRepository.findDoctorProfilesByClinic_CityAndSpecializationAndApprovedIsTrue(city, specialization);
  }

  public String getDoctorName(String email){
    return doctorProfileRepository.findDoctorProfileByCredential_Email(email).getName();
  }


  public ResponseEntity<DoctorProfile> updateDoctorProfile(DoctorProfileDTO newInfo, long id){

    DoctorProfile dc = doctorProfileRepository.findById(id).orElseThrow(
            () -> new DoctorNotFoundException(id));

    doctorProfileMapper.updateDoctorProfileFromDto(newInfo, dc);

    final DoctorProfile updatedDoctor = doctorProfileRepository.save(dc);
    return ResponseEntity.ok(updatedDoctor);
  }


}
