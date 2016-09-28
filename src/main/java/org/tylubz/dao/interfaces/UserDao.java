package org.tylubz.dao.interfaces;

import org.tylubz.entity.UserEntity;

/**
 * Created by Sergei on 28.09.2016.
 */
public interface UserDao extends GenericDao<UserEntity,Integer> {
    UserEntity getEntityByUsernameAndPassword(String username, String password);
    UserEntity getEntityByUsername(String username);
}
