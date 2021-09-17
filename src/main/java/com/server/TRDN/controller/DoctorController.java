package com.server.TRDN.controller;

import com.server.TRDN.model.Appointment;
import com.server.TRDN.model.PatientProfile;
import com.server.TRDN.service.AppointmentService;
import com.server.TRDN.service.DoctorService;
import com.server.TRDN.service.PatientService;
import com.server.TRDN.service.PrescriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/doctor")
public class DoctorController {

  private final PatientService patientService;
  private final AppointmentService appointmentService;
  private final DoctorService doctorService;
  private final PrescriptionService prescriptionService;

  public DoctorController(PatientService patientService, AppointmentService appointmentService, DoctorService doctorService, PrescriptionService prescriptionService) {
    this.patientService = patientService;
    this.appointmentService = appointmentService;
    this.doctorService = doctorService;
    this.prescriptionService = prescriptionService;
  }

  @RequestMapping(value = "/patients/profiles", method = RequestMethod.GET)
  public List<PatientProfile> getAllPatientsProfiles() {
    return patientService.getAllPatientProfiles() ;
  }

  @GetMapping("/appointments/{doctorID}")
  List<Appointment> appointmentsByDoctorID(@PathVariable Long doctorID){
    return appointmentService.getAppointmentsByDoctorID(doctorID);
  }

  @GetMapping("/docInfo/{doctorID}")
  String doctorNameByDoctorID(@PathVariable Long doctorID){
    String dn = doctorService.getDoctorProfileByID(doctorID).getName() + " "
            + doctorService.getDoctorProfileByID(doctorID).getSurname();
    return dn;
  }


}
