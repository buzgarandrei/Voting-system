package com.services;

import com.dto.request.*;

public interface AdminService {

    void addVotingSession(VotingSessionRequest votingSessionRequest) throws Exception;
    void deleteVotingSession(Long id) throws Exception;
    void updateVotingSession(VotingSessionRequest votingSessionRequest) throws Exception;

    void addUser(UserRequest userRequest) throws Exception;
    void deleteUser(Long idUser) throws Exception;
    boolean updateUser(UserRequest userRequest) throws Exception;

    void addVote(Long loggedInUserId, VoteRequest voteRequest) throws Exception;
    void deleteVote(Long idVote) throws Exception;

    boolean activateUser(ActivationRequest activationRequest) throws Exception;
}
