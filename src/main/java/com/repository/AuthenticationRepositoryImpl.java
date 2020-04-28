package com.repository;

import com.security.RoleType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Repository
public class AuthenticationRepositoryImpl implements AuthenticationRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional(readOnly = true)
    @Override
    public Long isValid(String username, String password) {

        Query query = entityManager.createNativeQuery("SELECT id FROM user " +
                "WHERE username = :username COLLATE utf8mb4_0900_as_cs " +
                "AND password = :password  COLLATE utf8mb4_0900_as_cs");

        query.setParameter("username", username);
        query.setParameter("password", password);

        List resultList = query.getResultList();
        if (resultList != null && !resultList.isEmpty()) {
            return ((BigInteger)resultList.get(0)).longValue();
        }
        else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public RoleType getUserRole(String username) {

        Query query = entityManager.createNativeQuery("SELECT r.name " +
                "FROM user AS u " +
                "INNER JOIN role AS r ON u.id_role = r.id " +
                "WHERE u.username = :username ");

        query.setParameter("username", username);
        List resultList = query.getResultList();
        if(resultList == null || resultList.isEmpty() || resultList.size() > 1) {

            return null;
        }
        String roleStr =  (String) resultList.get(0);
        RoleType roleType = RoleType.valueOf(roleStr);
        return roleType;
    }
}
