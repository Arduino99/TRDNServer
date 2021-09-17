package com.server.TRDN.controller;

import com.server.TRDN.model.Appointment;
import com.server.TRDN.service.AppointmentService;
import com.server.TRDN.service.PrescriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/patient")
public class PatientController {

  private final AppointmentService appointmentService;
  private final PrescriptionService prescriptionService;


  public PatientController(AppointmentService appointmentService, PrescriptionService prescriptionService) {
    this.appointmentService = appointmentService;
    this.prescriptionService = prescriptionService;
  }

  @GetMapping("/appointments/{patientID}")
  List<Appointment> appointmentsByPatientID(@PathVariable Long patientID){
    return appointmentService.getAppointmentsByPatientID(patientID);
  }
}
