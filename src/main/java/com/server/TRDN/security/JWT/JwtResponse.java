package com.server.TRDN.security.JWT;

import java.io.Serializable;

/*
  This class will return a response containing the JWT to be returned to the user.
 */
public class JwtResponse implements Serializable {

  private final String jwttoken;
  private final String role;
  private final String name;
  private final Long id;

//  public JwtResponse(String jwttoken) {
//    this.jwttoken = jwttoken;
//  }


  public JwtResponse(String jwttoken, String role, String name, Long id) {
    this.jwttoken = jwttoken;
    this.role = role;
    this.name = name;
    this.id = id;
  }

  public String getToken() {
    return this.jwttoken;
  }

  public String getRole() {
    return role;
  }

  public String getName() {
    return name;
  }

  public Long getId() {
    return id;
  }
}