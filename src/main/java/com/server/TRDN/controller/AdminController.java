package com.server.TRDN.controller;

import com.server.TRDN.DTO.*;
import com.server.TRDN.model.*;
import com.server.TRDN.repository.AuthoritiesRepository;
import com.server.TRDN.repository.CredentialsRepository;
import com.server.TRDN.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/admin")
//@PreAuthorize("hasRole('ADMIN')")
//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {

  private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

  private final DoctorService doctorService;
  private final PatientService patientService;
  private final PrescriptionService prescriptionService;
  private final AppointmentService appointmentService;
  private final AllergyService allergyService;
  private final ClinicService clinicService;

  //-----
  private final CredentialsRepository credentialsRepository;
  private final AuthoritiesRepository authoritiesRepository;

  public AdminController(DoctorService doctorService, PatientService patientService,
                         PrescriptionService prescriptionService, AppointmentService appointmentService,
                         AllergyService allergyService, ClinicService clinicService,
                         CredentialsRepository credentialsRepository, AuthoritiesRepository authoritiesRepository) {
    this.doctorService = doctorService;
    this.patientService = patientService;
    this.prescriptionService = prescriptionService;
    this.appointmentService = appointmentService;
    this.allergyService = allergyService;
    this.clinicService = clinicService;
    this.credentialsRepository = credentialsRepository;
    this.authoritiesRepository = authoritiesRepository;
  }

//  @GetMapping("/users")
//  public String getUsers(HttpServletRequest request) {
//    if (request.isUserInRole("ROLE_ADMIN")) {
//      System.out.println("Has Admin authority");
//      return "Has Admin authority";
//    }
//
//    if (request.isUserInRole("ROLE_PATIENT")) {
//      System.out.println("Has patient authority");
//      return "Has patient authority";
//    }
//
//    if (request.isUserInRole("ROLE_DOCTOR")) {
//      System.out.println("Has doctor authority");
//      return "Has doctor authority";
//    }
//
//    return ("DO NOT Have authority " + request.getAuthType()) ;
//  }


  @RequestMapping(value = "/patients/profiles", method = RequestMethod.GET)
  public List<PatientProfile> getAllPatientsProfiles() {
    return patientService.getAllPatientProfiles() ;
  }

  @RequestMapping(value = "/doctors", method = RequestMethod.GET)
  public List<DoctorProfile> getAllDoctors() {
    return doctorService.getAllDoctors() ;
  }

  @RequestMapping(value = "/prescriptions", method = RequestMethod.GET)
  public List<Prescription> getAllPrescriptions() {
    return prescriptionService.getAllPrescriptions() ;
  }

  @RequestMapping(value = "/allergies", method = RequestMethod.GET)
  public List<PatientAllergy> getAllPatientAllergies() {
    return allergyService.getAllPatientAllergies();
  }

  @RequestMapping(value = "/appointments", method = RequestMethod.GET)
  public List<Appointment> getAllAppointments() {
    return appointmentService.getAllAppointments();
  }

  @RequestMapping(value = "/clinics", method = RequestMethod.GET)
  public List<Clinic> getAllClinics() {
    return clinicService.getAllClinics();
  }

  @RequestMapping(value = "/credentials", method = RequestMethod.GET)
  public List<Credentials> getAllCredentials(){return credentialsRepository.findAll();}

  @RequestMapping(value = "/authorities", method = RequestMethod.GET)
  public List<Authorities> getAllAuth(){return authoritiesRepository.findAll();}


  /*
   * *******************************  Doctor Methods  ******************************
   * */



  //**************************** Approve doctor account ****************************
  @PutMapping("/doctors/{id}/approve")
  public DoctorProfile updateDoctorAccount(@PathVariable Long id) {
//    return doctorService.getDoctorProfileByID(id).setApproved(true);
    return doctorService.approveDoctor(id);
  }

  //***************************** Update doctor profile *****************************
  @PutMapping(value = "/doctors/{id}", consumes={"application/json"})
  ResponseEntity<DoctorProfile> updateDoctorProfile(@RequestBody DoctorProfileDTO doc, @PathVariable Long id) {
    return doctorService.updateDoctorProfile(doc, id);
  }

  //***************************** Delete doctor profile *****************************
  @DeleteMapping("/doctors/delete/{id}")
  void deleteDoctor(@PathVariable Long id){
    doctorService.deleteDoctorProfile(id);
  }

  //***************************** Find doctors to approve *************************
  @GetMapping("/doctors/not/approved")
  List<DoctorProfile> docsNotApproved(){
    return doctorService.getDoctorsNotApproved();
  }

  //***************************** Return approved doctors *************************
  @GetMapping("/doctors/approved")
  List<DoctorProfile> docsApproved(){
    return doctorService.getDoctorsApproved();
  }

  //***************************** Return approved doctors *************************
  @GetMapping("/doctors/specialization/{specialization}")
  List<DoctorProfile> docsBySpecialization(@PathVariable String specialization){
    return doctorService.getDoctorsBySpecialization(specialization);
  }

  //*****************Find doctors by city and specialization **********************
  @GetMapping("/doctors/{city}/{specialization}")
  List<DoctorProfile> docsByCityAndSpecialization(@PathVariable String city, @PathVariable String specialization){
    return doctorService.getDoctorsByCityAndSpecialization(city, specialization);
  }



  /*
   * *******************************  Clinic Methods  ******************************
   * */


  //***************************** Search Clinic by ID *****************************
  @GetMapping("/clinic/{id}")
  Clinic clinic(@PathVariable Long id) {
    return clinicService.getClinicByID(id);
  }

  //*****************************    Delete Clinic    *****************************
  //TODO TESTING THIS METHOD
  @DeleteMapping("/clinic/{id}")
  void deleteClinic(@PathVariable Long id) {
    clinicService.deleteClinicById(id);
  }

  //*************************** Add new Clinic Location ***************************
  @PostMapping("/clinics")
  Clinic newClinic(@RequestBody Clinic clinic) {
    return clinicService.newClinic(clinic);
  }

  //*************************** Update Clinic ***************************
  @PutMapping(value = "/clinic/{id}", consumes={"application/json"})
  ResponseEntity<Clinic> updateClinic(@RequestBody ClinicDTO clinic, @PathVariable Long id) {
    return clinicService.updateClinic(clinic, id);
  }

  /*
   * *******************************  Patient Methods  ******************************
   * */

  //***************************** Search patient by ID *****************************


  //************************* Update Patient Profile by ID ************************
  @PutMapping(value = "/patients/profile/{id}", consumes={"application/json"})
  ResponseEntity<PatientProfile> updatePatientProfile(@RequestBody PatientProfileDTO patient, @PathVariable Long id) {
    return patientService.updatePatientProfile(patient, id);
  }

  //****************************** Delete patient ID ******************************
  @DeleteMapping("/patients/{id}")
  void deletePatient(@PathVariable Long id){
    patientService.deletePatient(id);
  }

  /*
   * *****************************  Prescription Methods  ****************************
   * */

  //***************************** Search prescription by ID *****************************
  @GetMapping("/prescriptions/{id}")
  Prescription prescription(@PathVariable Long id) {
    return prescriptionService.getPrescriptionByID(id);
  }

  //************************* Update Prescription by ID ************************
  @PutMapping(value = "/prescriptions/{id}", consumes={"application/json"})
  ResponseEntity<Prescription> updatePrescription(@RequestBody PrescriptionDTO prescription, @PathVariable Long id){
    return prescriptionService.updatePrescription(prescription, id);
  }

  //****************************** Delete prescription ******************************
  @DeleteMapping("/prescriptions/{id}")
  void deletePrescription(@PathVariable Long id){
    prescriptionService.deletePrescription(id);
  }

  //*************************** Add new Prescription ***************************
  @PostMapping("/prescriptions")
  Prescription newPrescription(@RequestBody Prescription prescription) {
    return prescriptionService.newPrescription(prescription);
  }



  /*
   * ******************************  Appointment Methods  *****************************
   * */

  //***************************** Search appointment by ID *****************************
  @GetMapping("/appointments/{id}")
  Appointment appointment(@PathVariable Long id) {
    return appointmentService.getAppointmentByID(id);
  }

  //************************* Update Appointment by ID ************************
  @PutMapping(value = "/appointments/{id}", consumes={"application/json"})
  ResponseEntity<Appointment> updateAppointment(@RequestBody AppointmentDTO appointment, @PathVariable Long id){
    return appointmentService.updateAppointment(appointment, id);
  }

  //****************************** Delete Appointment ******************************
  @DeleteMapping("/appointments/{id}")
  void deleteAppointment(@PathVariable Long id){
    appointmentService.deleteAppointment(id);
  }

  //*************************** Add new Appointment ***************************
  @PostMapping("/appointments")
  Appointment newAppointment(@RequestBody Appointment appointment) {
    return appointmentService.newAppointment(appointment);
  }

  //********************** Return appointments by DoctorID *********************
  @GetMapping("/appointments/byDoctorID=/{doctorID}")
  List<Appointment> appointmentsByDoctorID(@PathVariable Long doctorID){
    return appointmentService.getAppointmentsByDoctorID(doctorID);
  }

  //********************** Return appointments by PatientID *********************
  @GetMapping("/appointments/byPatientID=/{patientID}")
  List<Appointment> appointmentsByPatientID(@PathVariable Long patientID){
    return appointmentService.getAppointmentsByPatientID(patientID);
  }
}

