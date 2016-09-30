package org.tylubz.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.tylubz.dao.interfaces.UserDao;
import org.tylubz.entity.UserEntity;

import javax.persistence.Query;

/**
 * Created by Sergei on 27.09.2016.
 */
@Repository
public class UserDaoImpl extends GenericDaoJpaImpl<UserEntity,Integer> implements UserDao {

//    @Autowired
//    public UserDaoImpl (){
//        super();
//    }

    /**
     * returns entity by username
     * and password
     *
     * @param username name of user
     * @param password password of user
     * @return entity
     */
    @Override
    public UserEntity getEntityByUsernameAndPassword(String username, String password) {
        String queryString = "SELECT a FROM UserEntity AS a WHERE a.username = :username AND a.password = :password";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (UserEntity) query.getResultList().get(0);
    }

    /**
     * returns entity by username
     *
     * @param username name of user
     * @return entity
     */
    @Override
    public UserEntity getEntityByUsername(String username) {
        String queryString = "SELECT a FROM UserEntity AS a WHERE a.username = :username";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("username", username);
        return (UserEntity) query.getResultList().get(0);
    }
}
