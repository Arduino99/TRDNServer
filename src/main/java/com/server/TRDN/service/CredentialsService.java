package com.server.TRDN.service;

import com.server.TRDN.model.Credentials;

import java.util.List;

public interface CredentialsService {

  Credentials register(Credentials user);

  List<Credentials> getAll();

  Credentials findByUsername(String username);

  Credentials findById(Long id);

  void delete(Long id);
}
