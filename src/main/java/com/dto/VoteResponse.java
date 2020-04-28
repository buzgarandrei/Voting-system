package com.dto;

import java.util.Date;

public class VoteResponse {

    private Long id;
    private String votingSession;
    private String userVoter;
    private String userCandidate;
    private String dateOfVoting;

    public VoteResponse() {
    }

    public VoteResponse(Long id, String votingSession, String userVoter, String userCandidate, String dateOfVoting) {
        this.id = id;
        this.votingSession = votingSession;
        this.userVoter = userVoter;
        this.userCandidate = userCandidate;
        this.dateOfVoting = dateOfVoting;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVotingSession() {
        return votingSession;
    }

    public void setVotingSession(String votingSession) {
        this.votingSession = votingSession;
    }

    public String getUserVoter() {
        return userVoter;
    }

    public void setUserVoter(String userVoter) {
        this.userVoter = userVoter;
    }

    public String getUserCandidate() {
        return userCandidate;
    }

    public void setUserCandidate(String userCandidate) {
        this.userCandidate = userCandidate;
    }

    public String getDateOfVoting() {
        return dateOfVoting;
    }

    public void setDateOfVoting(String dateOfVoting) {
        this.dateOfVoting = dateOfVoting;
    }
}
