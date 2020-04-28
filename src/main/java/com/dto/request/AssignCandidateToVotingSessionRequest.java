package com.dto.request;

public class AssignCandidateToVotingSessionRequest {

    private Long userCandidateId;
    private Long votingSessionId;

    public Long getUserCandidateId() {
        return userCandidateId;
    }

    public void setUserCandidateId(Long userCandidateId) {
        this.userCandidateId = userCandidateId;
    }

    public Long getVotingSessionId() {
        return votingSessionId;
    }

    public void setVotingSessionId(Long votingSessionId) {
        this.votingSessionId = votingSessionId;
    }
}
