package com.repository;

import com.dto.request.*;
import com.entities.*;
import com.security.RoleType;
import com.util.Utils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    @Override
    public void addVotingSession(VotingSessionRequest votingSessionRequest) throws Exception {

        try {
            VotingSessionEntity votingSessionEntity = new VotingSessionEntity();

            String dateStartStr = votingSessionRequest.getDateStart();

            votingSessionEntity.setDateStart(parseStringToDate(dateStartStr));

            String dateEndStr = votingSessionRequest.getDateEnd();

            votingSessionEntity.setDateEnd(parseStringToDate(dateEndStr));
            votingSessionEntity.setNameOfVotingSession(votingSessionRequest.getNameOfVotingSession());

            entityManager.persist(votingSessionEntity);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional
    public void deleteVotingSession(Long id) throws Exception {

        VotingSessionEntity votingSessionEntity = entityManager.find(VotingSessionEntity.class, id);
        entityManager.remove(votingSessionEntity);
    }

    @Override
    @Transactional
    public void updateVotingSession(VotingSessionRequest votingSessionRequest) throws Exception {

        try {

            VotingSessionEntity votingSessionEntity = new VotingSessionEntity();

            String dateStartStr = votingSessionRequest.getDateStart();
            String dateEndStr = votingSessionRequest.getDateEnd();

            votingSessionEntity.setDateStart(parseStringToDate(dateStartStr));
            votingSessionEntity.setDateEnd(parseStringToDate(dateEndStr));
            votingSessionEntity.setNameOfVotingSession(votingSessionRequest.getNameOfVotingSession());
            votingSessionEntity.setId(votingSessionRequest.getId());

            Query query = entityManager.createQuery("update VotingSessionEntity vs set vs.nameOfVotingSession= :nameOfVotingSession, vs.dateStart= :dateStart, vs.dateEnd= :dateEnd where vs.id= :id ");
            query.setParameter("id", votingSessionEntity.getId());
            query.setParameter("nameOfVotingSession", votingSessionEntity.getNameOfVotingSession());
            query.setParameter("dateStart", votingSessionEntity.getDateStart());
            query.setParameter("dateEnd", votingSessionEntity.getDateEnd());

            query.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private Date parseStringToDate(String dateStr) throws Exception {

        Date date = Utils.DATE_FORMAT.parse(dateStr);
        return date;
    }

    @Override
    @Transactional
    public void addUser(UserRequest userRequest) throws Exception {

        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setCnp(userRequest.getCnp());
            userEntity.setName(userRequest.getName());
            userEntity.setUsername(userRequest.getUsername());
            userEntity.setPassword(userRequest.getPassword());
            RoleEntity role = entityManager.find(RoleEntity.class, RoleType.VOTER.getId());
            userEntity.setRole(role);

            UserDetailEntity userDetailEntity = new UserDetailEntity();
            userDetailEntity.setAddress(userRequest.getAddress());
            userDetailEntity.setCounty(userRequest.getCounty());
            userDetailEntity.setEmail(userRequest.getEmail());
            userDetailEntity.setLocality(userRequest.getLocality());

            entityManager.persist(userEntity);

            userDetailEntity.setUser(userEntity);
            entityManager.persist(userDetailEntity);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional
    public void deleteUser(Long idUser) throws Exception {

        try {
            UserEntity userEntity = entityManager.find(UserEntity.class,idUser);
            entityManager.remove(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional
    public boolean updateUser(UserRequest userRequest) throws Exception {

        try {
            Long userId = userRequest.getId();

            UserEntity userEntity = entityManager.find(UserEntity.class, userId);
            userEntity.setUsername(userRequest.getUsername());
            userEntity.setName(userRequest.getName());
            userEntity.setCnp(userRequest.getCnp());

            entityManager.merge(userEntity);

            UserDetailEntity userDetailEntity = entityManager.find(UserDetailEntity.class, userId);
            userDetailEntity.setAddress(userRequest.getAddress());
            userDetailEntity.setCounty(userRequest.getCounty());
            userDetailEntity.setEmail(userRequest.getEmail());
            userDetailEntity.setLocality(userRequest.getLocality());

            entityManager.merge(userDetailEntity);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional
    public void addVote(Long loggedInUserId, VoteRequest voteRequest) throws Exception {

        try {
            VoteEntity voteEntity = new VoteEntity();

            UserEntity userVoter = entityManager.find(UserEntity.class, loggedInUserId);
            if(!userVoter.getIsActive()) {
                System.out.println("Error with permission, inactive user trying to vote");
                return;
            }

            voteEntity.setUserVoter(userVoter);

            Date currentDate = new Date();
            voteEntity.setDateOfVoting(currentDate);

            UserEntity userCandidate = entityManager.find(UserEntity.class, voteRequest.getUserCandidate());
            if(!userCandidate.getIsActive()) {
                System.out.println("Error with permission, inactive candidate ");
                return;
            }
            voteEntity.setUserCandidate(userCandidate);

            VotingSessionEntity votingSessionEntity = entityManager.find(VotingSessionEntity.class, voteRequest.getVotingSession());

            voteEntity.setVotingSession(votingSessionEntity);

            entityManager.persist(voteEntity);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional
    public void deleteVote(Long idVote) throws Exception {
        try {
            VoteEntity voteEntity = entityManager.find(VoteEntity.class, idVote);
            entityManager.remove(voteEntity);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional
    public boolean activateUser(ActivationRequest activationRequest) throws Exception {

        try {
            Long userId = activationRequest.getId();
            UserEntity userEntity = entityManager.find(UserEntity.class, userId);
            if(userEntity == null) {
                System.out.println("User not found for given id = " + userId);
                return false;
            }
            userEntity.setIsActive(activationRequest.isActivation());
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
