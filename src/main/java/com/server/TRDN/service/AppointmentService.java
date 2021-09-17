package com.server.TRDN.service;

import com.server.TRDN.DTO.AppointmentDTO;
import com.server.TRDN.mapper.AppointmentMapper;
import com.server.TRDN.controller.Exceptions.AppointmentNotFoundException;
import com.server.TRDN.model.Appointment;
import com.server.TRDN.repository.AppointmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
  private final AppointmentRepository appointmentRepository;
  private final AppointmentMapper appointmentMapper;

  public AppointmentService(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
    this.appointmentRepository = appointmentRepository;
    this.appointmentMapper = appointmentMapper;
  }

  public List<Appointment> getAllAppointments() {
    return (List<Appointment>) appointmentRepository.findAll();
  }

  public Appointment getAppointmentByID(Long id) {
    return appointmentRepository.findById(id).orElseThrow(() -> new AppointmentNotFoundException(id));
  }

  public void deleteAppointment(Long id){
    appointmentRepository.deleteById(id);
  }

  public List<Appointment> getAppointmentsByDoctorID(Long doctorID) {
    return appointmentRepository.findAppointmentsByDoctorIDId(doctorID);
  }

  public List<Appointment> getAppointmentsByPatientID(Long patientID) {
    return appointmentRepository.findAppointmentsByPatientIDId(patientID);
  }

  public Appointment newAppointment(Appointment appointment){
    return appointmentRepository.save(appointment);
  }


  public ResponseEntity<Appointment> updateAppointment(AppointmentDTO newInfo, Long id){

    Appointment ap = appointmentRepository.findById(id).orElseThrow(
            () -> new AppointmentNotFoundException(id));

    appointmentMapper.updateAppointmentFromDto(newInfo, ap);

    final Appointment updatedAppointment = appointmentRepository.save(ap);
    return ResponseEntity.ok(updatedAppointment);
  }
}
