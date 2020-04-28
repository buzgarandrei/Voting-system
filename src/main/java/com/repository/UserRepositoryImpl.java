package com.repository;

import com.dto.CandidateVotesResultResponse;
import com.dto.StateResponse;
import com.dto.UserCandidateResponse;
import com.entities.UserEntity;
import com.entities.VotingSessionEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<UserCandidateResponse> getVotingSessionCandidateList(Long votingSessionId) {

        VotingSessionEntity votingSessionEntity = entityManager.find(VotingSessionEntity.class, votingSessionId);
        List<UserEntity> candidates = votingSessionEntity.getCandidates();

        List<UserCandidateResponse> userCandidateList = new ArrayList<>();

        for (UserEntity candidate : candidates) {

            UserCandidateResponse userCandidateResponse = new UserCandidateResponse();

            userCandidateResponse.setId(candidate.getId());
            userCandidateResponse.setName(candidate.getName());

            userCandidateList.add(userCandidateResponse);
        }

        return userCandidateList;
    }

    @Transactional
    @Override
    public StateResponse assignCandidateToVotingSession(Long userCandidateId, Long votingSessionId) {

        UserEntity userEntity = entityManager.find(UserEntity.class, userCandidateId);
        VotingSessionEntity votingSessionEntity = entityManager.find(VotingSessionEntity.class, votingSessionId);

        userEntity.getVotingSessions().add(votingSessionEntity);
        entityManager.merge(userEntity);

        StateResponse stateResponse = new StateResponse();
        stateResponse.setSuccess(true);
        return stateResponse;
    }


    @Transactional
    @Override
    public List<CandidateVotesResultResponse> getVoteResults(Long votingSessionId) {

        Query query = entityManager.createNativeQuery("SELECT uCandidate.name AS candidate, COUNT(v.id) AS votes " +
                "FROM vote AS v " +
                "INNER JOIN user AS uCandidate ON uCandidate.id = v.id_user_candidate  " +
                "WHERE v.id_voting_session = :votingSessionId " +
                "GROUP BY v.id_user_candidate " +
                "ORDER BY COUNT(v.id) DESC", Tuple.class);

        query.setParameter("votingSessionId", votingSessionId);

        List<Tuple> resultList = query.getResultList();

        List<CandidateVotesResultResponse> candidateVotesResultResponses = new ArrayList<>();

        if (resultList == null) {
            return candidateVotesResultResponses;
        }

        for (Tuple tuple : resultList) {

            CandidateVotesResultResponse resultResponse = new CandidateVotesResultResponse();
            resultResponse.setCandidate((String) tuple.get("candidate"));
            resultResponse.setNumberOfVotes(((BigInteger) tuple.get("votes")).intValue());

            candidateVotesResultResponses.add(resultResponse);
        }

        return candidateVotesResultResponses;
    }
}
