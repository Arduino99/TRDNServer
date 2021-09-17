package com.server.TRDN.controller.Exceptions;

public class PrescriptionNotFoundException extends RuntimeException{
  public PrescriptionNotFoundException(Long id) {
    super("Could not find prescription " + id);
  }
}
