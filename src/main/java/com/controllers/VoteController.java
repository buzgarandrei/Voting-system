package com.controllers;

import com.dto.StateResponse;
import com.dto.VoteResponse;
import com.dto.request.IdRequest;
import com.dto.request.VoteRequest;
import com.security.RoleType;
import com.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class VoteController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @Autowired
    private VoteService votesService;


    @RequestMapping("/voteList")
    @ResponseBody
    public List<VoteResponse> getVotesList(HttpServletRequest httpServletRequest) {

        boolean validated = authenticationService.validateTokenAndRole(httpServletRequest, RoleType.ADMIN);
        if (!validated) {
            return null;
        }

        return votesService.getVotes();
    }

    @RequestMapping(value = "/addVote", method = RequestMethod.POST)
    @ResponseBody
    public StateResponse addVote(HttpServletRequest httpServletRequest, @RequestBody VoteRequest voteRequest) {

        boolean validated = authenticationService.validateTokenAndRole(httpServletRequest, null);
        if (!validated) {
            return null;
        }
        StateResponse stateResponse = new StateResponse();

        try {
            Long loggedInUserId = authenticationService.getUserIdByToken(httpServletRequest);

            adminServiceImpl.addVote(loggedInUserId, voteRequest);

            stateResponse.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;

    }

    @RequestMapping(value = "/deleteVote",method = RequestMethod.POST)
    @ResponseBody
    public StateResponse deleteVote(HttpServletRequest httpServletRequest, @RequestBody IdRequest idRequest) {

        boolean validated = authenticationService.validateTokenAndRole(httpServletRequest,RoleType.ADMIN);
        if(!validated) {
            return null;
        }
        StateResponse stateResponse = new StateResponse();

        try{
            adminServiceImpl.deleteVote(idRequest.getId());
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

}
