package com.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "voting_session")
public class VotingSessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany(mappedBy = "votingSessions")
    private List<UserEntity> candidates = new ArrayList<>();

    @Column(name = "name_of_voting_session")
    private String nameOfVotingSession;

    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_end")
    private Date dateEnd;


    public VotingSessionEntity() {
    }

    public VotingSessionEntity(String nameOfVotingSession, Date dateStart, Date dateEnd) {
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

    public List<UserEntity> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<UserEntity> candidates) {
        this.candidates = candidates;
    }

    public String getNameOfVotingSession() {
        return nameOfVotingSession;
    }

    public void setNameOfVotingSession(String nameOfVotingSession) {
        this.nameOfVotingSession = nameOfVotingSession;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date date_start) {
        this.dateStart = date_start;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date date_end) {
        this.dateEnd = date_end;
    }

}
