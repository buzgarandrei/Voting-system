package com.services;

import com.dto.CandidateVotesResultResponse;
import com.dto.StateResponse;
import com.dto.UserCandidateResponse;
import com.dto.UserResponse;
import com.entities.RoleEntity;
import com.entities.UserDetailEntity;
import com.entities.UserEntity;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.UserCrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserCrudRepository userCrudRepository;


    @Transactional
    @Override
    public List<UserResponse> findAll() {

        List<UserResponse> userResponses = new ArrayList<>();

        List<UserEntity> userEntityList = (List<UserEntity>) userCrudRepository.findAll();
        for (UserEntity userEntity : userEntityList) {

            UserResponse userResponse = new UserResponse();
            userResponses.add(userResponse);

            userResponse.setId(userEntity.getId());
            userResponse.setCnp(userEntity.getCnp());
            userResponse.setName(userEntity.getName());
            userResponse.setUserName(userEntity.getUsername());

            UserDetailEntity userDetailEntity = userEntity.getDetail();

            userResponse.setAddress(userDetailEntity.getAddress());
            userResponse.setCounty(userDetailEntity.getCounty());
            userResponse.setEmail(userDetailEntity.getEmail());
            userResponse.setLocality(userDetailEntity.getLocality());

            RoleEntity role = userEntity.getRole();
            userResponse.setRole(role.getName());
        }
        return userResponses;
    }

    @Transactional
    @Override
    public List<UserCandidateResponse> getVotingSessionCandidateList(Long votingSessionId) {
        return  userRepository.getVotingSessionCandidateList(votingSessionId);
    }

    @Override
    public StateResponse assignCandidateToVotingSession(Long userCandidateId, Long votingSessionId) {

        return userRepository.assignCandidateToVotingSession(userCandidateId, votingSessionId);
    }

    @Override
    public List<CandidateVotesResultResponse> getVoteResults(Long votingSessionId) {

        return userRepository.getVoteResults(votingSessionId);
    }

}
