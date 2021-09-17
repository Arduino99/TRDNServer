package com.server.TRDN.repository;

import com.server.TRDN.model.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<Credentials, Long> {

  Credentials findByEmail(String email);

}
