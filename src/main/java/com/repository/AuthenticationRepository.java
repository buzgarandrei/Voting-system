package com.repository;

import com.security.RoleType;

public interface AuthenticationRepository {

    public Long isValid(String username, String password);

    public RoleType getUserRole(String username);

}
