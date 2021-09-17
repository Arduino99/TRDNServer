package com.server.TRDN.security.JWT;

import com.server.TRDN.model.Authorities;
import com.server.TRDN.model.Credentials;
import com.server.TRDN.service.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  private final CredentialsService cr;


  @Autowired
  public JwtUserDetailsService(CredentialsService userService) {
    this.cr = userService;
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Credentials credential = cr.findByUsername(username);

    if (credential == null) {
      throw new UsernameNotFoundException("User with username: " + username + " not found");
    }

    return new User(credential.getEmail(), credential.getPassword(), mapToGrantedAuthorities(credential.getAuthorities()));
  }

  private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authorities> userAuth) {
    return userAuth.stream()
            .map(role ->
                    new SimpleGrantedAuthority(role.getPk().getAuthority())
            ).collect(Collectors.toList());
  }
}
