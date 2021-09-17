package com.server.TRDN.controller.Exceptions;

public class ClinicNotFoundException extends RuntimeException{
  public ClinicNotFoundException(Long id) {
    super("Could not find clinic " + id);
  }
}
