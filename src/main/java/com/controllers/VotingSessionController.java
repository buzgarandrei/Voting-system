package com.controllers;

import com.dto.CandidateVotesResultResponse;
import com.dto.StateResponse;
import com.dto.UserCandidateResponse;
import com.dto.VotingSessionResponse;
import com.dto.request.AssignCandidateToVotingSessionRequest;
import com.dto.request.IdRequest;
import com.dto.request.VotingSessionRequest;
import com.entities.VotingSessionEntity;
import com.security.RoleType;
import com.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class VotingSessionController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private VotingService votingService;

    @Autowired
    private UserService userService;


    @RequestMapping("/votingSessionList")
    @ResponseBody
    public List<VotingSessionResponse> getVotingSessions(HttpServletRequest httpServletRequest) {

        boolean validated = authenticationService.validateTokenAndRole(httpServletRequest, null);
        if (!validated) {
            return null;
        }

        List<VotingSessionEntity> votingSessionEntityList = votingService.getVotingSession();

        return votingSessionEntityList.stream().map(this::ConvertToVotingSessionResponse).collect(Collectors.toList());
    }

    private VotingSessionResponse ConvertToVotingSessionResponse(VotingSessionEntity votingSessionEntity) {

        VotingSessionResponse votingSessionResponse = new VotingSessionResponse(
                votingSessionEntity.getId(),
                votingSessionEntity.getNameOfVotingSession(),
                votingSessionEntity.getDateStart().toString(),
                votingSessionEntity.getDateEnd().toString());

        return votingSessionResponse;
    }

    @RequestMapping(value = "/addVotingSession", method = RequestMethod.POST)
    @ResponseBody
    public StateResponse addVotingSession(HttpServletRequest httpServletRequest, @RequestBody VotingSessionRequest votingSessionRequest) {

        boolean validated = authenticationService.validateTokenAndRole(httpServletRequest, RoleType.ADMIN);
        if (!validated) {
            return null;
        }

        StateResponse stateResponse = new StateResponse();

        try {
            adminService.addVotingSession(votingSessionRequest);
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }

        return stateResponse;
    }

    @RequestMapping(value = "/updateVotingSession", method = RequestMethod.POST)
    @ResponseBody
    public StateResponse updateVotingSession(HttpServletRequest httpServletRequest, @RequestBody VotingSessionRequest votingSessionRequest) {

        boolean validated = authenticationService.validateTokenAndRole(httpServletRequest,RoleType.ADMIN);
        if(!validated) {
            return null;
        }

        StateResponse stateResponse = new StateResponse();

        try {
            adminService.updateVotingSession(votingSessionRequest);
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/deleteVotingSession", method = RequestMethod.POST)
    @ResponseBody
    public StateResponse deleteVotingSession(HttpServletRequest httpServletRequest, @RequestBody IdRequest idRequest) {

        boolean validated = authenticationService.validateTokenAndRole(httpServletRequest,RoleType.ADMIN);
        if(!validated) {
            return null;
        }

        StateResponse stateResponse = new StateResponse();

        try {
            adminService.deleteVotingSession(idRequest.getId());
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/votingSessionCandidateList", method = RequestMethod.POST)
    @ResponseBody
    public List<UserCandidateResponse> getVotingSessionCandidateList(HttpServletRequest httpServletRequest, @RequestBody IdRequest idRequest) {

        boolean validated = authenticationService.validateTokenAndRole(httpServletRequest, null);
        if(!validated) {
            return null;
        }

        return userService.getVotingSessionCandidateList(idRequest.getId());
    }

    @RequestMapping(value = "/assignCandidateToVotingSession", method = RequestMethod.POST)
    @ResponseBody
    public StateResponse assignCandidateToVotingSession(HttpServletRequest httpServletRequest, @RequestBody AssignCandidateToVotingSessionRequest request) {

        boolean validated = authenticationService.validateTokenAndRole(httpServletRequest, RoleType.ADMIN);
        if(!validated) {
            return null;
        }

        return userService.assignCandidateToVotingSession(request.getUserCandidateId(), request.getVotingSessionId());
    }

    @RequestMapping(value = "/voteResults", method = RequestMethod.POST)
    @ResponseBody
    public List<CandidateVotesResultResponse> getVoteResults(HttpServletRequest httpServletRequest, @RequestBody AssignCandidateToVotingSessionRequest request) {

        boolean validated = authenticationService.validateTokenAndRole(httpServletRequest, null);
        if(!validated) {
            return null;
        }

        return userService.getVoteResults(request.getVotingSessionId());
    }

}
