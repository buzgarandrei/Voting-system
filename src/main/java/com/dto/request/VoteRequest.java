package com.dto.request;

public class VoteRequest {

    private Long votingSession;
    private Long userCandidate;

    public Long getVotingSession() {
        return votingSession;
    }

    public void setVotingSession(Long votingSession) {
        this.votingSession = votingSession;
    }

    public Long getUserCandidate() {
        return userCandidate;
    }

    public void setUserCandidate(Long userCandidate) {
        this.userCandidate = userCandidate;
    }
}
