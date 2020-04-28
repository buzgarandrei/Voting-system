package com.services;

import com.dto.CandidateVotesResultResponse;
import com.dto.StateResponse;
import com.dto.UserCandidateResponse;
import com.dto.UserResponse;
import com.entities.UserEntity;

import java.util.List;

public interface UserService {

    List<UserResponse> findAll();

    List<UserCandidateResponse> getVotingSessionCandidateList(Long votingSessionId);

    StateResponse assignCandidateToVotingSession(Long userCandidateId, Long votingSessionId);

    List<CandidateVotesResultResponse> getVoteResults(Long votingSessionId);

}
