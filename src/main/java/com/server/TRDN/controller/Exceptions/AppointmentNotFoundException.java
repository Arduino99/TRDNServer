package com.server.TRDN.controller.Exceptions;

public class AppointmentNotFoundException extends RuntimeException{
  public AppointmentNotFoundException(Long id) {
    super("Could not find appointment " + id);
  }
}

