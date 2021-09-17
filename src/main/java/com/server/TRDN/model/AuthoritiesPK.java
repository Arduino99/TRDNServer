package com.server.TRDN.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class AuthoritiesPK implements Serializable {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
  @JsonIdentityReference(alwaysAsId = true)
  private Credentials credentialID;

  @JoinColumn(name = "authority", nullable = false)
  private String authority;

  public AuthoritiesPK() { }

  public AuthoritiesPK(Credentials credentials, String authority) {
    this.credentialID = credentials;
    this.authority = authority;
  }

  public Credentials getCredentialID() {
    return credentialID;
  }

  public void setCredentialID(Credentials credentials) {
    this.credentialID = credentials;
  }

  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }
}
