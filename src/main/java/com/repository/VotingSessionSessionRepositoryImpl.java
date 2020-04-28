package com.repository;

import com.entities.VotingSessionEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Repository
public class VotingSessionSessionRepositoryImpl implements VotingSessionRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<VotingSessionEntity> getVotingSessionList () {

        Query query = entityManager.createQuery("select vs from VotingSessionEntity vs where vs.dateStart <= :date and vs.dateEnd >= :date  ", VotingSessionEntity.class);
        query.setParameter("date", new Date());

        return query.getResultList();
    }
}
