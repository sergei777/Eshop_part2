package org.tylubz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tylubz.dao.exceptions.DaoStoreException;
import org.tylubz.dao.interfaces.UserDao;
import org.tylubz.entity.UserEntity;
import org.tylubz.service.interfaces.UserService;

/**
 * Created by Sergei on 26.09.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity create(UserEntity entity) throws DaoStoreException{
        return userDao.create(entity);
    }

    @Override
    public UserEntity read(Integer id) throws DaoStoreException {
        return userDao.read(id);
    }

    @Override
    public void update(UserEntity entity) throws DaoStoreException {
        userDao.update(entity);
    }

    @Override
    public void delete(UserEntity entity) throws DaoStoreException {
        userDao.delete(entity);
    }
}
