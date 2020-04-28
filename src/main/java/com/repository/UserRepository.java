package com.repository;

import com.dto.CandidateVotesResultResponse;
import com.dto.StateResponse;
import com.dto.UserCandidateResponse;

import java.util.List;

public interface UserRepository {

    List<UserCandidateResponse> getVotingSessionCandidateList(Long votingSessionId);

    StateResponse assignCandidateToVotingSession(Long userCandidateId, Long votingSessionId);

    List<CandidateVotesResultResponse> getVoteResults(Long votingSessionId);

}
