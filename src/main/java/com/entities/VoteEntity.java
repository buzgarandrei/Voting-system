package com.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "vote", uniqueConstraints={
        @UniqueConstraint(columnNames = {"id_voting_session", "id_user_voter"})})
public class VoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "id_voting_session")
    @ManyToOne
    private VotingSessionEntity votingSession;

    @JoinColumn(name = "id_user_voter", nullable = false)
    @ManyToOne
    private UserEntity userVoter;

    @JoinColumn(name = "id_user_candidate")
    @ManyToOne
    private UserEntity userCandidate;

    @Column(name = "date_of_voting")
    private Date dateOfVoting;

    public VoteEntity() {
    }

    public VoteEntity(VotingSessionEntity votingSession, UserEntity userVoter, UserEntity userCandidate, Date dateOfVoting) {
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

    public VotingSessionEntity getVotingSession() {
        return votingSession;
    }

    public void setVotingSession(VotingSessionEntity votingSessionEntity) {
        this.votingSession = votingSessionEntity;
    }

    public UserEntity getUserVoter() {
        return userVoter;
    }

    public void setUserVoter(UserEntity userEntityVoter) {
        this.userVoter = userEntityVoter;
    }

    public UserEntity getUserCandidate() {
        return userCandidate;
    }

    public void setUserCandidate(UserEntity userEntityCandidate) {
        this.userCandidate = userEntityCandidate;
    }

    public Date getDateOfVoting() {
        return dateOfVoting;
    }

    public void setDateOfVoting(Date dateOfVoting) {
        this.dateOfVoting = dateOfVoting;
    }
}
