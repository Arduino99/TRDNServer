package com.server.TRDN.repository;

import com.server.TRDN.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

  public List<Appointment> findAppointmentsByApprovedIsTrue();

  public List<Appointment> findAppointmentsByDoctorIDId(Long doctorID);

  public List<Appointment> findAppointmentsByPatientIDId(Long patientID);

}
