package com.repository;

import com.entities.VoteEntity;

import java.util.List;

public interface VoteRepository {

    public List<VoteEntity> getVotesList();
}
