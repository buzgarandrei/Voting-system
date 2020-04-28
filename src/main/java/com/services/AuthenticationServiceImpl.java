package com.services;

import com.dto.StateResponse;
import com.repository.AuthenticationRepository;
import com.security.RoleType;
import com.security.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final String REQUEST_HEADER_TOKEN = "REQUEST_HEADER_TOKEN";

    public static final boolean VALIDATION_ACTIVE = false;

    @Autowired
    private AuthenticationRepository authenticationRepository;

    private Map<String, UserSession> sessionMap = new HashMap();

    public Long isValid(String username, String password) {

        return authenticationRepository.isValid(username, password);
    }

    @Override
    public RoleType getUserRole(String username) {
        return authenticationRepository.getUserRole(username) ;
    }


    public String registerLogin(Long userId, String username, RoleType roleType) {

        String token = UUID.randomUUID().toString();

        UserSession userSession = new UserSession();
        userSession.setUserId(userId);
        userSession.setUsername(username);
        userSession.setToken(token);
        userSession.setRoleType(roleType);

        sessionMap.put(token, userSession);

        return token;
    }

    public StateResponse logout(String token) {

        StateResponse stateResponse = new StateResponse();
        if(sessionMap.remove(token) != null) {
            stateResponse.setSuccess(true);
        }
        else {
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    public boolean validateTokenAndRole(HttpServletRequest httpServletRequest, RoleType roleTypeRequested) {

        if (!VALIDATION_ACTIVE) {
            return true;
        }

        String requestHeaderToken = httpServletRequest.getHeader(REQUEST_HEADER_TOKEN);
        if(requestHeaderToken == null) {
            return false;
        }

        UserSession userSession = sessionMap.get(requestHeaderToken);

        if (userSession == null) {
            return false;
        }

        if(roleTypeRequested == null) {
            return true;
        }

        RoleType roleTypeLoggedUser = userSession.getRoleType();

        if(roleTypeLoggedUser == RoleType.ADMIN) {
            return true;
        }

        if (roleTypeLoggedUser != roleTypeRequested) {
            return false;
        }

        return true;
    }

    public boolean validateTokenAndUser(HttpServletRequest httpServletRequest, Long userId) {

        if (!VALIDATION_ACTIVE) {
            return true;
        }

        String requestHeaderToken = httpServletRequest.getHeader(REQUEST_HEADER_TOKEN);
        if(requestHeaderToken == null) {
            return false;
        }

        UserSession userSession = sessionMap.get(requestHeaderToken);

        if (userSession == null) {
            return false;
        }

        if(userId == null) {
            return false;
        }

        Long sessionUserId = userSession.getUserId();

        return sessionUserId.equals(userId);
    }

    public Long getUserIdByToken(HttpServletRequest httpServletRequest) {

        String requestHeaderToken = httpServletRequest.getHeader(REQUEST_HEADER_TOKEN);
        if(requestHeaderToken == null) {
            return null;
        }

        UserSession userSession = sessionMap.get(requestHeaderToken);

        if (userSession == null) {
            return null;
        }

        return userSession.getUserId();
    }
}

