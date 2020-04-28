package com.controllers;

import com.dto.LoginResponse;
import com.dto.StateResponse;
import com.dto.request.LoginRequest;
import com.dto.request.LogoutRequest;
import com.security.RoleType;
import com.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping("/da")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Long userId = authenticationService.isValid(username, password);
        boolean success = (userId != null);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setSuccess(success);

        if (success) {

            RoleType roleType = authenticationService.getUserRole(username);
            String token = authenticationService.registerLogin(userId, username, roleType);

            loginResponse.setToken(token);
            loginResponse.setRoleType(roleType);
        }
        return loginResponse;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public StateResponse logout(@RequestBody LogoutRequest logoutRequest) {

        return authenticationService.logout(logoutRequest.getToken());
    }

}
