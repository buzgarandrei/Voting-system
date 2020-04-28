package com.repository;

import com.entities.VoteEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class VoteRepositoryImpl implements VoteRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<VoteEntity> getVotesList() {

        Query query = entityManager.createQuery("select v from VoteEntity v", VoteEntity.class);
        List<VoteEntity> resultList = query.getResultList();
        return resultList;
    }
}
