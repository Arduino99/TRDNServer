package com.server.TRDN.security.JWT;

import java.io.Serializable;

/*
 * This class will store the username and password we receive from the client
 */
public class JwtRequest implements Serializable {

  private String username;
  private String password;

  // need default constructor for JSON Parsing
  public JwtRequest() { }

  public JwtRequest(String username, String password) {
    this.setUsername(username);
    this.setPassword(password);
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}