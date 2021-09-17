package com.server.TRDN.service;

import com.server.TRDN.model.Credentials;
import com.server.TRDN.repository.AuthoritiesRepository;
import com.server.TRDN.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialsServiceImpl implements CredentialsService{

  private final CredentialsRepository userRepository;
  private final AuthoritiesRepository authRepository;


  @Autowired
  public CredentialsServiceImpl(CredentialsRepository userRepository, AuthoritiesRepository authRepository) {
    this.userRepository = userRepository;
    this.authRepository = authRepository;
  }

  @Override
  public Credentials register(Credentials user) {
    return null;
  }

  @Override
  public List<Credentials> getAll() {
    List<Credentials> users = userRepository.findAll();
    return users;
  }

  @Override
  public Credentials findByUsername(String username) {
    Credentials user = userRepository.findByEmail(username);
    return user;
  }

  @Override
  public Credentials findById(Long id) {
    Credentials user = userRepository.findById(id).orElse(null);
    return user;
  }

  @Override
  public void delete(Long id) {
    userRepository.deleteById(id);
  }
}
