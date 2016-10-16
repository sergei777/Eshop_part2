package org.tylubz.dao.impl;

import org.springframework.stereotype.Repository;
import org.tylubz.dao.interfaces.UserDao;
import org.tylubz.model.entity.UserEntity;

import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Created by Sergei on 27.09.2016.
 */
@Repository
public class UserDaoImpl extends GenericDaoJpaImpl<UserEntity,Integer> implements UserDao {

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
        UserEntity result = null;
        try{
            result = (UserEntity) query.getSingleResult();
        }
        catch (NoResultException e){
            //nothing to do
        }
        return result;
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
        UserEntity result = null;
        try{
            result = (UserEntity) query.getSingleResult();
        }
        catch (NoResultException e){
            //nothing to do
        }
        return result;
    }
    @Override
    public UserEntity getEntityByEmail(String email) {
        String queryString = "SELECT a FROM UserEntity AS a WHERE a.email = :email";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("email", email);
        UserEntity result = null;
        try{
            result = (UserEntity) query.getSingleResult();
        }
        catch (NoResultException e){
            //nothing
        }
        return result;
    }
}
