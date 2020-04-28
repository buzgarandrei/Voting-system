package com.services;

import com.entities.VotingSessionEntity;
import com.repository.VotingSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingServiceImpl implements VotingService {

    @Autowired
    public VotingSessionRepository votingSessionRepository;

    public List<VotingSessionEntity> getVotingSession() {
        return votingSessionRepository.getVotingSessionList();
    }
}
