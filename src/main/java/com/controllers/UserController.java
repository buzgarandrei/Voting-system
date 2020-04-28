package com.controllers;
import com.dto.StateResponse;
import com.dto.UserResponse;
import com.dto.request.ActivationRequest;
import com.dto.request.IdRequest;
import com.dto.request.UserRequest;
import com.security.RoleType;
import com.services.AdminServiceImpl;
import com.services.AuthenticationService;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @RequestMapping("/userList")
    @ResponseBody
    public List<UserResponse> getUserList(HttpServletRequest httpServletRequest) {

        boolean validated = authenticationService.validateTokenAndRole(httpServletRequest, RoleType.ADMIN);
        if (!validated) {
            return null;
        }

        List<UserResponse> userResponseList;
        userResponseList = userService.findAll();
        return userResponseList;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public StateResponse addUsers(HttpServletRequest httpServletRequest, @RequestBody UserRequest userRequest) {

        boolean validated = authenticationService.validateTokenAndRole(httpServletRequest, null);
        if (!validated) {
            return null;
        }
        StateResponse stateResponse = new StateResponse();

        try {
            adminServiceImpl.addUser(userRequest);
            stateResponse.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public StateResponse updateUsers(HttpServletRequest httpServletRequest, @RequestBody UserRequest userRequest) {

        boolean validated = authenticationService.validateTokenAndRole(httpServletRequest, RoleType.ADMIN);
        if (!validated) {

            validated = authenticationService.validateTokenAndUser(httpServletRequest, userRequest.getId());
            if (!validated) {
                return null;
            }
        }

        StateResponse stateResponse = new StateResponse();

        try {
            boolean success = adminServiceImpl.updateUser(userRequest);
            stateResponse.setSuccess(success);
        } catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    @ResponseBody
    public StateResponse deleteUsers(HttpServletRequest httpServletRequest, @RequestBody IdRequest idRequest) {

        boolean validated = authenticationService.validateTokenAndRole(httpServletRequest, RoleType.ADMIN);
        if (!validated) {
            return null;
        }
        StateResponse stateResponse = new StateResponse();

        try {
            adminServiceImpl.deleteUser(idRequest.getId());
            stateResponse.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/activateUser")
    @ResponseBody
    public StateResponse activateUser(HttpServletRequest httpServletRequest, @RequestBody ActivationRequest activationRequest) {

        boolean validated = authenticationService.validateTokenAndRole(httpServletRequest, RoleType.ADMIN);
        if (!validated) {
            return null;
        }

        StateResponse stateResponse = new StateResponse();

        try {
            boolean success = adminServiceImpl.activateUser(activationRequest);
            stateResponse.setSuccess(success);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }

        return stateResponse;
    }

}
