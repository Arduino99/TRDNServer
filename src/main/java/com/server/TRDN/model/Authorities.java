package com.server.TRDN.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authorities")
public class Authorities implements Serializable {

  @EmbeddedId
  AuthoritiesPK pk;

  public Authorities(AuthoritiesPK pt) {
    this.pk = pt;
  }

  public Authorities() { }

  public AuthoritiesPK getPk() {
    return pk;
  }

  public void setPk(AuthoritiesPK pt) {
    this.pk = pt;
  }
}
