package com.services;

import com.dto.request.*;
import com.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    public AdminRepository adminRepository;

    @Override
    public void addVotingSession(VotingSessionRequest votingSessionRequest) throws Exception {
        adminRepository.addVotingSession(votingSessionRequest);
    }

    @Override
    public void deleteVotingSession(Long id) throws Exception {
        adminRepository.deleteVotingSession(id);
    }

    @Override
    public void updateVotingSession(VotingSessionRequest votingSessionRequest) throws Exception {
        adminRepository.updateVotingSession(votingSessionRequest);
    }

    @Override
    public void addUser(UserRequest userRequest) throws Exception {
        adminRepository.addUser(userRequest);
    }

    @Override
    public void deleteUser(Long idUser) throws Exception {
        adminRepository.deleteUser(idUser);
    }

    @Override
    public boolean updateUser(UserRequest userRequest) throws Exception {
        return adminRepository.updateUser(userRequest);
    }

    @Override
    public void addVote(Long loggedInUserId, VoteRequest voteRequest) throws Exception {
        adminRepository.addVote(loggedInUserId, voteRequest);
    }

    public void deleteVote(Long idVote) throws Exception{
        adminRepository.deleteVote(idVote);
    }

    @Override
    public boolean activateUser(ActivationRequest activationRequest) throws Exception {
        return adminRepository.activateUser(activationRequest);
    }
}
