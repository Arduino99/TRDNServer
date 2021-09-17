package com.server.TRDN.security.JWT;

import com.server.TRDN.service.CredentialsService;
import com.server.TRDN.service.DoctorService;
import com.server.TRDN.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/*
  This file contains authentication rest API that receives the username and password for authentication and it returns
  the JWT token on successful response.
 */

@RestController
@CrossOrigin
public class JwtAuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private JwtUserDetailsService userDetailsService;

  @Autowired
  private DoctorService doctorService;

  @Autowired
  private PatientService patientService;

  @Autowired
  private CredentialsService credentialsService;

  @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
    authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

    final UserDetails userDetails = userDetailsService
            .loadUserByUsername(authenticationRequest.getUsername());
    final String token = jwtTokenUtil.generateToken(userDetails);

    String role = userDetails.getAuthorities().toString();
    String permission = role.substring(1, role.length() -1);

    String name = "Null";

    Long id = credentialsService.findByUsername(authenticationRequest.getUsername()).getId();

    if(permission.equals("ROLE_ADMIN")){
      name = "Admin";
    }
    if(permission.equals("ROLE_DOCTOR")){
      name = doctorService.getDoctorName(userDetails.getUsername());
    }
    if(permission.equals("ROLE_PATIENT")){
      name = patientService.getPatientName(userDetails.getUsername());
    }

    return ResponseEntity.ok(new JwtResponse(token, permission, name, id));
  }

  private void authenticate(String username, String password) throws Exception {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new Exception("USER_DISABLED", e);
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENTIALS", e);
    }
  }
}
