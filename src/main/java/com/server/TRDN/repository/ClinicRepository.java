package com.server.TRDN.repository;

import com.server.TRDN.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {

  public List<Clinic> findByName(String name);

  public List<Clinic> findByPostcode(String postcode);
}
