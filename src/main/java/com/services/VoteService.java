package com.services;

import com.dto.VoteResponse;

import java.util.List;

public interface VoteService {

    public List<VoteResponse> getVotes();
}
