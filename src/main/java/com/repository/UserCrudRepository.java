package com.repository;

import com.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserCrudRepository extends CrudRepository<UserEntity, Long> {

}
