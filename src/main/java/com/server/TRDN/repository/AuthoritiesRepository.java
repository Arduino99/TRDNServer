package com.server.TRDN.repository;

import com.server.TRDN.model.Authorities;
import com.server.TRDN.model.AuthoritiesPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, AuthoritiesPK> {

}
