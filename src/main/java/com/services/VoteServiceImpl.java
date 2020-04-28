package com.services;

import com.dto.VoteResponse;
import com.entities.VoteEntity;
import com.repository.VoteRepository;
import com.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    public VoteRepository voteRepository;

    @Transactional
    public List<VoteResponse> getVotes() {

        List<VoteResponse> voteResponseList = new ArrayList<>();

        List<VoteEntity> votesList = voteRepository.getVotesList();

        for (VoteEntity voteEntity : votesList) {

            VoteResponse voteResponse = new VoteResponse(
                    voteEntity.getId(),
                    voteEntity.getVotingSession().getNameOfVotingSession(),
                    voteEntity.getUserVoter().getName(),
                    voteEntity.getUserCandidate().getName(),
                    Utils.DATE_FORMAT.format(voteEntity.getDateOfVoting())
            );

            voteResponseList.add(voteResponse);
        }
        return voteResponseList;
    }

}
