package com.services;

import com.dto.StateResponse;
import com.security.RoleType;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationService {

    Long isValid(String username, String password);

    RoleType getUserRole(String username);

    String registerLogin(Long userId, String username, RoleType roleType);

    boolean validateTokenAndRole(HttpServletRequest httpServletRequest, RoleType roleTypeRequested);

    boolean validateTokenAndUser(HttpServletRequest httpServletRequest, Long userId);

    Long getUserIdByToken(HttpServletRequest httpServletRequest);

    StateResponse logout(String token);
}
