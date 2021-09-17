package com.server.TRDN.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "credentials")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Credentials implements Serializable {

  @Id
  @Column(name = "credential_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Email
  @Size(max = 50)
  @Column(unique = true)
//  @NaturalId
  private String email;

  @NotNull
  @Size(max = 255)
  @Column(name = "password")
  private String password;

  @NotNull
  @Column(name = "enabled")
  private Boolean approved;

  @OneToMany(cascade = CascadeType.ALL,
          fetch = FetchType.LAZY,
          mappedBy = "pk.credentialID")
  private List<Authorities> authorities;

  public Credentials() { }

  public Credentials(Long id, String email, Boolean approved) {
    this.id = id;
    this.email = email;
    this.approved = approved;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getApproved() {
    return approved;
  }

  public void setApproved(Boolean approved) {
    this.approved = approved;
  }

  @Transient
  public List<Authorities> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(List<Authorities> authorities) {
    this.authorities = authorities;
  }
}
