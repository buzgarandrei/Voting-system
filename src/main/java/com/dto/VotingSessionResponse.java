package com.dto;


public class VotingSessionResponse {


    private Long id;
    private String nameOfVotingSession;
    private String dateStart;
    private String dateEnd;

    public VotingSessionResponse() {
    }

    public VotingSessionResponse(Long id, String nameOfVotingSession, String dateStart, String dateEnd) {
        this.id = id;
        this.nameOfVotingSession = nameOfVotingSession;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfVotingSession() {
        return nameOfVotingSession;
    }

    public void setNameOfVotingSession(String nameOfVotingSession) {
        this.nameOfVotingSession = nameOfVotingSession;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
}
