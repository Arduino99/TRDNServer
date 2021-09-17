package com.server.TRDN.controller.Exceptions;

public class PatientNotFoundException extends RuntimeException{
  public PatientNotFoundException(Long id) {
    super("Could not find patient " + id);
  }
}
