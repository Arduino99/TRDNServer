package com.server.TRDN.security.JWT;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/*
  Provides core user information. Implementations are not used directly by Spring Security for security purposes.
  They simply store user information which is later encapsulated into Authentication objects.
  This allows non-security related user information (such as email addresses, telephone numbers etc)
  to be stored in a convenient location.
 */
public class JwtUser implements UserDetails {

  private static final long serialVersionUID = 1L;

  private final Long id;
  private final String email;
  private final String password;
  private final Boolean approved;
  private final Collection<? extends GrantedAuthority> authorities;

  public JwtUser(Long id, String email, String password, Boolean approved, Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.approved = approved;
    this.authorities = authorities;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public String getPassword() {
    return null;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public boolean isEnabled() {
    return approved;
  }
}
